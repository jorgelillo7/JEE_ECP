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

	private String successMsg;

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

	public String getSuccessMsg() {
		return successMsg;
	}

	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
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
		temas = this.controllerFactory.getEliminarTemaController()
				.mostrarTemas();
	}

	public String eliminarTema() {
		boolean check = this.controllerFactory.getEliminarTemaController()
				.deleteTema(this.id);
		if (check) {
			this.setSuccessMsg("Tema " + this.id + " eliminado con éxito");
		} else {
			this.setErrorMsg("Ocurrió un error al intentar borrar");
		}
		return "home";
	}

	public boolean checkPassword() {
		boolean check = this.controllerFactory.getEliminarTemaController()
				.passwordCorrecto(this.password);
		if (check == false) {
			this.setErrorMsg("Password incorrecto");
		}
		return check;
	}

}
