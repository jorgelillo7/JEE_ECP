package controllers.ws;

import java.util.List;

import ws.TemaUris;
import models.entities.Tema;
import models.utils.ListTemas;
import controllers.EliminarTemaController; 

public class EliminarTemaControllerWS extends ControllerWs implements
EliminarTemaController{

	@Override
	public boolean deleteTema(Integer id) {
		ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS, id.toString())
        .delete();
		return true;
	}

	@Override
	public List<Tema> mostrarTemas() {
		WsManager wsManager = ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS);
        if (wsManager.read()) { 
            return wsManager.entity(ListTemas.class).getListTemas();
        }
        return null;
	}

	@Override
	public boolean passwordCorrecto(String password) {
		WsManager wsManager = ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS,
                TemaUris.PATH_AUTENTICAR);
		wsManager.addParams("code", password);
        return wsManager.entityBoolean();
	}

}
