package controllers.ejbs;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import controllers.ControllerFactory;
import controllers.EliminarTemaController;
import controllers.NuevoTemaController;
 

@ManagedBean(name = "controllerFactory")
@SessionScoped
public class ControllerEjbFactory extends ControllerFactory {
 
    private NuevoTemaController nuevoTemaController;
    private EliminarTemaController eliminarTemaController;

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

}
