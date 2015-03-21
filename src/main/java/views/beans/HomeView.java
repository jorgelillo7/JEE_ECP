package views.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import models.entities.Tema;
import controllers.ControllerFactory;

@ManagedBean
public class HomeView {

	@ManagedProperty(value = "#{controllerFactory}")
	private ControllerFactory controllerFactory;

	private String password;

	private String errorMsg;

	private String successMsg;
 
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	  
	public void setControllerFactory(ControllerFactory controllerFactory) {
		this.controllerFactory = controllerFactory;
	}
	
	public boolean checkPassword() {
		boolean check = this.controllerFactory.getEliminarTemaController()
				.passwordCorrecto(this.password);
		if (check == false) {
			this.setErrorMsg("Password incorrecto");
		}
		return check;
	}
 
	public String process() {
		boolean check = this.controllerFactory.getEliminarTemaController()
				.passwordCorrecto(this.password);
		if (check == false) {
			this.setErrorMsg("Password incorrecto");
			return "home";
		} else {
			return "eliminarTema";
		}
		
		
	} 

}
