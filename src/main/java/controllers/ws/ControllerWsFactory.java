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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EliminarTemaController getEliminarTemaController() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public A�adirVotoController getA�adirVotoController() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VerVotacionesController getVerVotacionesController() {
		// TODO Auto-generated method stub
		return null;
	}

}
