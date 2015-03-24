package controllers.ws;
 
import java.util.List;

import ws.TemaUris;
import ws.VotoUris;
import models.entities.Tema;
import models.utils.ListNivelEstudios;
import models.utils.ListTemas;
import models.utils.NivelEstudios;
import controllers.VerVotacionesController;

public class VerVotacionesControllerWS implements
VerVotacionesController{

	@Override
	public List<Tema> getListaTemas() {
		WsManager wsManager = ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS);
        if (wsManager.read()) { 
            return wsManager.entity(ListTemas.class).getListTemas();
        }
        return null;
	}

	@Override
	public List<Long> getNumeroVotos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NivelEstudios> getListaNivelEstudios() {
		WsManager wsManager = ControllerWs.buildWebServiceManager(VotoUris.PATH_NIVELESTUDIOS);
        if (wsManager.read()) { 
            return wsManager.entity(ListNivelEstudios.class).getListNivel();
        }
		return null;
	}

	@Override
	public List<List<String>> getListaMedia() {
		// TODO
		return null;
	}

}
