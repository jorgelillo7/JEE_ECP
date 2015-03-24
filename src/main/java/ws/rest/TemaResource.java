package ws.rest;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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

	private void debug(String msg) {
		LogManager.getLogger(this.getClass()).debug(TemaUris.PATH_TEMAS + msg);
	}

    @POST
    @Consumes({MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_XML})
    public Response añadirTema(Tema tema) {
        LogManager.getLogger(clazz).debug("Llamada al metodo create " + tema);
        TemaDao temaDao = DaoFactory.getFactory().getTemaDao();
        temaDao.create(tema);
        LogManager.getLogger(clazz).debug("Tema creado con id "+tema.getId());
        return Response.ok(tema).build();
    }
    
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

}
