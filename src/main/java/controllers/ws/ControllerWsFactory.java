package controllers.ws;

import controllers.AñadirVotoController;
import controllers.ControllerFactory;
import controllers.EliminarTemaController;
import controllers.NuevoTemaController;
import controllers.VerVotacionesController;
 
public class ControllerWsFactory extends ControllerFactory {

	private NuevoTemaController nuevoTemaController;
	private EliminarTemaController eliminarTemaController;
	private AñadirVotoController añadirVotoController;
	private VerVotacionesController verVotacionesController;

	public ControllerWsFactory() {
	}

	@Override
	public NuevoTemaController getNuevoTemaControler() {
		if (nuevoTemaController == null) {
			nuevoTemaController = new NuevoTemaControllerWS();
        }
        return nuevoTemaController;
	}

	@Override
	public EliminarTemaController getEliminarTemaController() {
		if (eliminarTemaController == null) {
			eliminarTemaController = new EliminarTemaControllerWS();
        }
        return eliminarTemaController;
	}

	@Override
	public AñadirVotoController getAñadirVotoController() {
		if (añadirVotoController == null) {
			añadirVotoController = new AñadirVotoControllerWS();
        }
        return añadirVotoController;
	}

	@Override
	public VerVotacionesController getVerVotacionesController() {
		if (verVotacionesController == null) {
			verVotacionesController = new VerVotacionesControllerWS();
        }
        return verVotacionesController;
	}

}
