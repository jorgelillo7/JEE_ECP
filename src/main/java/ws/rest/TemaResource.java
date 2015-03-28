package ws.rest;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET; 
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam; 
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.entities.Tema;
import models.entities.Voto;
import models.utils.ListLong;
import models.utils.ListMedias; 
import models.utils.NivelEstudios;

import org.apache.logging.log4j.LogManager;

import ws.TemaUris; 

@Stateless
@Path(TemaUris.PATH_TEMAS)
public class TemaResource {
	private final static Class<TemaResource> clazz = TemaResource.class;
	private static final String PASSWORD_CORRECTO = "666";

	// http://localhost:8080/JEE_ECP/rest/temas/9
	@GET
	@Path(TemaUris.PATH_ID_PARAM)
	@Consumes({ MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_XML })
	public Response consultar(@PathParam("id") Integer id) {
		TemaDao temaDao = DaoFactory.getFactory().getTemaDao();
		Tema tema = temaDao.read(id);
		LogManager.getLogger(clazz).debug("Buscar tema con id " + tema.getId());
		return Response.ok(tema).build();
	}

	// http://localhost:8080/JEE_ECP/rest/temas/
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Tema> consultarTodos() {
		TemaDao temaDao = DaoFactory.getFactory().getTemaDao();
		List<Tema> temas = temaDao.findAll();
		LogManager.getLogger(clazz).debug(
				"GET: " + TemaUris.PATH_TEMAS + ": " + temas);
		return temas;
	}

	// Ejemplo en JerseyClient.java
	@POST
	@Consumes({ MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_XML })
	public Response añadir(Tema tema) {
		LogManager.getLogger(clazz).debug("Llamada al metodo create " + tema);
		TemaDao temaDao = DaoFactory.getFactory().getTemaDao();
		temaDao.create(tema);
		LogManager.getLogger(clazz).debug("Tema creado con id " + tema.getId());
		return Response.ok(tema).build();
	}

	// http://localhost:8080/JEE_ECP/rest/temas/25?id=25&code=666 (DELETE probado con PostMan)
	@DELETE
	@Path(TemaUris.PATH_ID_PARAM)
	public Response eliminar(@PathParam("id") Integer id,
			@QueryParam("code") String code) {
		if (code == null) {
			code = "";
		}
		if (!code.equals(PASSWORD_CORRECTO)) {
			return Response.ok(
					"Error de autenticación no se pudo eliminar el tema")
					.build();

		}

		TemaDao temaDao = DaoFactory.getFactory().getTemaDao();
		LogManager.getLogger(clazz).debug("Eliminando tema con id " + id);
		temaDao.deleteById(id);

		return Response.ok("Tema borrado con éxito").build();
	}

	// http://localhost:8080/JEE_ECP/rest/temas/autenticar/?code=666
	@GET
	@Path(TemaUris.PATH_AUTENTICAR)
	public String autenticar(@QueryParam("code") String code) {
		LogManager.getLogger(clazz).debug(
				"GET: " + TemaUris.PATH_TEMAS + "/" + TemaUris.PATH_AUTENTICAR
						+ ": " + code);
		return Boolean.toString(code.equals(PASSWORD_CORRECTO));
	}

	// http://localhost:8080/JEE_ECP/rest/temas/listNumVotos
	@GET
	@Path(TemaUris.PATH_LIST_NUM_VOTOS)
	@Produces(MediaType.APPLICATION_XML)
	public Response listNumeroVotos() {
		List<Long> listaVotos = new ArrayList<Long>();
		List<Tema> temas = DaoFactory.getFactory().getTemaDao().findAll();

		long count = 0;
		for (Tema tema : temas) {
			count = DaoFactory.getFactory().getTemaDao().countVotosByTema(tema);
			listaVotos.add(count);
		}
		LogManager.getLogger(clazz).debug(
				"GET: " + TemaUris.PATH_LIST_NUM_VOTOS + ": ");

		ListLong listLong = new ListLong();
		listLong.setListLong(listaVotos);
		Response response = Response.ok(listLong).build();
		return response;
	}

	// http://localhost:8080/JEE_ECP/rest/temas/mediaVotos
	@GET
	@Path(TemaUris.PATH_MEDIA_VOTOS)
	@Produces(MediaType.APPLICATION_JSON)
	public ListMedias listaMedias() {
		List<Tema> temas = DaoFactory.getFactory().getTemaDao().findAll();
		NivelEstudios[] nivelEstudios = NivelEstudios.values();
		List<NivelEstudios> nivelEstudiosList = new ArrayList<NivelEstudios>();
		for (NivelEstudios nivelEstudiosIt : nivelEstudios) {
			nivelEstudiosList.add(nivelEstudiosIt);
		}
		List<NivelEstudios> listaEstudios = nivelEstudiosList;

		List<List<String>> listaNivelesPorTema = new ArrayList<List<String>>();
		List<String> mediaListNivel;

		for (int i = 0; i < temas.size(); i++) {
			Tema tema = temas.get(i);
			int votosPorPregunta = 0;
			mediaListNivel = new ArrayList<String>();

			for (int j = 0; j < listaEstudios.size(); j++) {
				NivelEstudios nivel = listaEstudios.get(j);

				List<Voto> votosPorPreguntaYNivel = DaoFactory.getFactory()
						.getTemaDao().findVotosByTemaAndNivel(tema, nivel);

				votosPorPregunta = votosPorPreguntaYNivel.size();
				int sumaValoraciones = 0;

				for (Voto voto : votosPorPreguntaYNivel) {
					sumaValoraciones += voto.getValoracion();
				}
				String mediaString = "";
				if (votosPorPregunta > 0) {
					double media = (double) sumaValoraciones
							/ (double) votosPorPregunta;
					DecimalFormat df = new DecimalFormat("0.00");
					mediaString = String.valueOf(df.format(media))
							+ " (Total: " + votosPorPregunta + ")";

				} else {
					mediaString = "0";
				}

				mediaListNivel.add(mediaString);
			}
			listaNivelesPorTema.add(mediaListNivel);

		}

		LogManager.getLogger(clazz).debug(
				"GET: " + TemaUris.PATH_MEDIA_VOTOS + ": ");

		ListMedias listMedia = new ListMedias();
		listMedia.setListMedia(listaNivelesPorTema);

		return listMedia;
	}

}
