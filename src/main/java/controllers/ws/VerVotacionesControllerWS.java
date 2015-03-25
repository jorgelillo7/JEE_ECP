package controllers.ws;
 
import java.util.List;

import ws.TemaUris;
import ws.VotoUris;
import models.entities.Tema;
import models.utils.ListLong;
import models.utils.ListMedias;
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
		WsManager wsManager = ControllerWs.buildWebServiceManager(TemaUris.PATH_LIST_NUM_VOTOS);
        if (wsManager.read()) { 
            return wsManager.entity(ListLong.class).getListLong();
        }
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
		WsManager wsManager = ControllerWs.buildWebServiceManager(TemaUris.PATH_MEDIA_VOTOS);
        if (wsManager.read()) { 
            return wsManager.entity(ListMedias.class).getListMedia();
        }
		return null;
	}

}
