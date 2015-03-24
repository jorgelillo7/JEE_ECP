package ws.rest;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 
import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.VotoDao;
import models.entities.Voto;
import models.utils.ListNivelEstudios; 
import models.utils.NivelEstudios;

import org.apache.logging.log4j.LogManager;

import ws.TemaUris;
import ws.VotoUris;

@Path(VotoUris.PATH_VOTOS)
public class VotoResource {

	private final static Class<VotoResource> clazz = VotoResource.class;
	private void debug(String msg) {
		LogManager.getLogger(this.getClass()).debug(TemaUris.PATH_TEMAS + msg);
	}
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response añadir(Voto voto) {
    	VotoDao votoDao = DaoFactory.getFactory().getVotoDao();
        Response result;
        votoDao.create(voto);
        result = Response.created(URI.create(VotoUris.PATH_VOTOS + "/" + voto.getId()))
                .entity(String.valueOf(voto.getId())).build();
        LogManager.getLogger(clazz).debug("POST: " + VotoUris.PATH_VOTOS + ": " + voto);
        return result;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response actualizar(Voto voto) {
    	VotoDao votoDao = DaoFactory.getFactory().getVotoDao();
        Response result;
        votoDao.update(voto);
        result = Response.created(URI.create(VotoUris.PATH_VOTOS + "/" + voto.getId()))
                .entity(String.valueOf(voto.getId())).build();
        LogManager.getLogger(clazz).debug("PUT: " + VotoUris.PATH_VOTOS + ": " + voto);
        return result;
    }

    //http://localhost:8080/JEE_ECP/rest/votos/35
    @GET
    @Path(VotoUris.PATH_ID_PARAM)
    @Produces(MediaType.APPLICATION_XML)
    public Voto consultar(@PathParam("id") Integer id) {
    	VotoDao votoDao = DaoFactory.getFactory().getVotoDao();
        Voto voto = votoDao.read(id);
        if (voto == null) {
            throw new NotFoundException();
        } else {
        	LogManager.getLogger(clazz).debug("GET: " + VotoUris.PATH_VOTOS + "/" + id + ": " + voto);
            return voto;
        }
    }

    //http://localhost:8080/JEE_ECP/rest/votos
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Voto> consultarTodos() {
    	VotoDao votoDao = DaoFactory.getFactory().getVotoDao();
        List<Voto> votos = votoDao.findAll();
        LogManager.getLogger(clazz).debug("GET: " + VotoUris.PATH_VOTOS + ": " + votos);
        return votos;
    }

    //http://localhost:8080/JEE_ECP/rest/votos/nivelEstudios
    @GET
    @Path(VotoUris.PATH_NIVELESTUDIOS)
    @Produces(MediaType.APPLICATION_XML)
    public ListNivelEstudios getStudiesLevel() {
        NivelEstudios[] nivelEstudios = NivelEstudios.values();
        List<NivelEstudios> nivelEstudiosList = new ArrayList<NivelEstudios>();
        for (NivelEstudios nivelEstudiosIt : nivelEstudios) {
            nivelEstudiosList.add(nivelEstudiosIt);
        }
        LogManager.getLogger(clazz).debug("GET: " + VotoUris.PATH_VOTOS + "/" + VotoUris.PATH_NIVELESTUDIOS + ": "
                + nivelEstudiosList);
        return new ListNivelEstudios(nivelEstudiosList);
    }

}