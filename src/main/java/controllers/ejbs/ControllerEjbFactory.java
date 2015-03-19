package controllers.ejbs;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import controllers.A�adirVotoController;
import controllers.ControllerFactory;
import controllers.EliminarTemaController;
import controllers.NuevoTemaController;
 

@ManagedBean(name = "controllerFactory")
@SessionScoped
public class ControllerEjbFactory extends ControllerFactory {
 
    private NuevoTemaController nuevoTemaController;
    private EliminarTemaController eliminarTemaController;
    private A�adirVotoController a�adirVotoController;

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
	public A�adirVotoController getA�adirVotoController() {
		if (a�adirVotoController == null) {
			a�adirVotoController = new A�adirVotoControllerEjb();
        }
        return a�adirVotoController; 
	}

}
