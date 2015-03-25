package controllers.ejbs;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import models.daos.DaoFactory;
import models.daos.jpa.DaoJpaFactory;
import controllers.AñadirVotoController;
import controllers.ControllerFactory;
import controllers.EliminarTemaController;
import controllers.NuevoTemaController;
import controllers.VerVotacionesController;
 

@ManagedBean(name = "controllerFactory")
@SessionScoped
public class ControllerEjbFactory extends ControllerFactory {
 
    private NuevoTemaController nuevoTemaController;
    private EliminarTemaController eliminarTemaController;
    private AñadirVotoController añadirVotoController;
    private VerVotacionesController verVotacionesController;

    public ControllerEjbFactory() { 
    }
 

	@Override
	public NuevoTemaController getNuevoTemaControler() {
		if (nuevoTemaController == null) {
			nuevoTemaController = new NuevoTemaControllerEjb();
        }
        return nuevoTemaController; 
	}
	
	@Override
	public EliminarTemaController getEliminarTemaController() {
		if (eliminarTemaController == null) {
			eliminarTemaController = new EliminarTemaControllerEjb();
        }
        return eliminarTemaController; 
	}


	@Override
	public AñadirVotoController getAñadirVotoController() {
		if (añadirVotoController == null) {
			añadirVotoController = new AñadirVotoControllerEjb();
        }
        return añadirVotoController; 
	}
	
	@Override
	public VerVotacionesController getVerVotacionesController() {
		if (verVotacionesController == null) {
			verVotacionesController = new VerVotacionesControllerEjb();
        }
        return verVotacionesController; 
	}


}
