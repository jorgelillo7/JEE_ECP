package views.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import models.entities.Tema;
import controllers.ControllerFactory;

@ManagedBean
public class EliminarTemaView {
	private ControllerFactory controllerFactory;

	private String password;

	private String errorMsg;

	public Integer id;

	public List<Tema> temas;

	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setControllerFactory(ControllerFactory controllerFactory) {
		this.controllerFactory = controllerFactory;
	}

	@PostConstruct
	public void mostrarListaTemas() {
		 System.out.println("Se actualizan datos de la capa de negocio");
		 temas = this.controllerFactory.getEliminarTemaController().mostrarTemas();
	     System.out.print("Temas: " + temas.size());
	}

	public String eliminarTema() {
		this.controllerFactory.getEliminarTemaController().deleteTema(this.id);
		return "home";
	}

}
