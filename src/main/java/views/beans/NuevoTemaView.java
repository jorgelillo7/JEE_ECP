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

	private String categoria;

	private String pregunta;

	public NuevoTemaView(){
		
	}
	public NuevoTemaView(String categoria, String pregunta) {
		this.categoria = categoria;
		this.pregunta = pregunta;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
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
		Tema tema = new Tema(this.categoria, this.pregunta);
		LogManager.getLogger(NuevoTemaView.class).debug(
				"Se accede a la capa de negocio para registrar tema: " + tema);

		controllerFactory.getNuevoTemaControler().saveTema(tema);
		return "home";

	}

}
