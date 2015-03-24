package controllers.ws;

import java.util.List;

import ws.TemaUris;
import ws.VotoUris;
import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.entities.Tema;
import models.entities.Voto;
import models.utils.ListNivelEstudios;
import models.utils.ListTemas;
import models.utils.NivelEstudios;
import controllers.AñadirVotoController; 

public class AñadirVotoControllerWS implements
AñadirVotoController{

	@Override
	public boolean saveVoto(Voto voto, int idTema) {
		TemaDao temaDao = DaoFactory.getFactory().getTemaDao();
		Tema tema = temaDao.read(idTema);
		voto.setTema(tema);
        ControllerWs.buildWebServiceManager(VotoUris.PATH_VOTOS).update(voto);
		return false;
	}

	@Override
	public List<Tema> getListaTemas() {
		WsManager wsManager = ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS);
        if (wsManager.read()) { 
            return wsManager.entity(ListTemas.class).getListTemas();
        }
        return null;
	}

	@Override
	public List<NivelEstudios> getListaEstudios() {
		WsManager wsManager = ControllerWs.buildWebServiceManager(VotoUris.PATH_NIVELESTUDIOS);
        if (wsManager.read()) { 
            return wsManager.entity(ListNivelEstudios.class).getListNivel();
        }
		return null;
	}

}
