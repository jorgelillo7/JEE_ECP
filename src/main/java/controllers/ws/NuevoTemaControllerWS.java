package controllers.ws;

import ws.TemaUris;
import models.entities.Tema;
import controllers.NuevoTemaController;

public class NuevoTemaControllerWS extends ControllerWs implements
		NuevoTemaController {

	@Override
	public boolean saveTema(Tema tema) {
		return ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS).create(
				tema);
	}

}
