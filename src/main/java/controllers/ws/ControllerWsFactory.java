package controllers.ws;

import controllers.AņadirVotoController;
import controllers.ControllerFactory;
import controllers.EliminarTemaController;
import controllers.NuevoTemaController;
import controllers.VerVotacionesController;
 
public class ControllerWsFactory extends ControllerFactory {

	private NuevoTemaController nuevoTemaController;
	private EliminarTemaController eliminarTemaController;
	private AņadirVotoController aņadirVotoController;
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
	public AņadirVotoController getAņadirVotoController() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VerVotacionesController getVerVotacionesController() {
		// TODO Auto-generated method stub
		return null;
	}

}
