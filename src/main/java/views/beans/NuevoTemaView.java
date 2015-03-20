package views.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import models.entities.Tema;

import org.apache.logging.log4j.LogManager;

import controllers.ControllerFactory;
import controllers.ejbs.NuevoTemaControllerEjb;

@ManagedBean
public class NuevoTemaView {
	@ManagedProperty(value = "#{controllerFactory}")
	private ControllerFactory controllerFactory;
	
	private String errorMsg;

	private Tema tema;

	public NuevoTemaView() {
		tema = new Tema();
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public void setControllerFactory(ControllerFactory controllerFactory) {
		this.controllerFactory = controllerFactory;
	}
	
	public void update() {
		/*
		 * LogManager.getLogger(TemaView.class).debug(
		 * "Se accede a la capa de negocio para recuperar roles"); this.roles =
		 * new String[] {"uno", "dos", "tres"};
		 */
	}

	public String process() {
		LogManager.getLogger(NuevoTemaView.class).debug(
				"Se accede a la capa de negocio para registrar tema: " + tema);

		controllerFactory.getNuevoTemaControler().saveTema(tema);
		return "home";

	}

}
