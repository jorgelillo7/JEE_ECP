package ws.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotAuthorizedException;
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

import org.apache.logging.log4j.LogManager;

import ws.TemaUris;

@Stateless
@Path(TemaUris.PATH_TEMAS)
public class TemaResource {
	private final static Class<TemaResource> clazz = TemaResource.class;
	private static final String PASSWORD_CORRECTO = "666";

	private void debug(String msg) {
		LogManager.getLogger(this.getClass()).debug(TemaUris.PATH_TEMAS + msg);
	}

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

	//http://localhost:8080/JEE_ECP/rest/temas/
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Tema> getAll() {
		TemaDao temaDao = DaoFactory.getFactory().getTemaDao();
		List<Tema> temas = temaDao.findAll();
		LogManager.getLogger(clazz).debug(
				"GET: " + TemaUris.PATH_TEMAS + ": " + temas);
		return temas;
	}

	//Ejemplo en JerseyClient.java
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

	// http://localhost:8080/JEE_ECP/rest/temas/25?id=25&code=666 (DELETE)
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

}
