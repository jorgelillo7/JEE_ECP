package controllers.ws;

import controllers.A�adirVotoController;
import controllers.ControllerFactory;
import controllers.EliminarTemaController;
import controllers.NuevoTemaController;
import controllers.VerVotacionesController;
 
public class ControllerWsFactory extends ControllerFactory {

	private NuevoTemaController nuevoTemaController;
	private EliminarTemaController eliminarTemaController;
	private A�adirVotoController a�adirVotoController;
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
	public A�adirVotoController getA�adirVotoController() {
		if (a�adirVotoController == null) {
			a�adirVotoController = new A�adirVotoControllerWS();
        }
        return a�adirVotoController;
	}

	@Override
	public VerVotacionesController getVerVotacionesController() {
		if (verVotacionesController == null) {
			verVotacionesController = new VerVotacionesControllerWS();
        }
        return verVotacionesController;
	}

}
