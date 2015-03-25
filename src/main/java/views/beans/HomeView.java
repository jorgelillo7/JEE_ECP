package views.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;

import ws.TemaUris;
import ws.rest.TemaResource;
import models.daos.DaoFactory;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Tema;
import controllers.ControllerFactory;

@ManagedBean
public class HomeView {

	@ManagedProperty(value = "#{controllerFactory}")
	private ControllerFactory controllerFactory;

	private final static Class<HomeView> clazz = HomeView.class;
	
	public HomeView() {
		this.locale = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestLocale();
	}

	public Locale getLocale() {
		return this.locale;
	}

	public String msg(String key) {
		return ResourceBundle.getBundle("i18n.messages", this.locale)
				.getString(key);
	}

	public String change(String language) {
		this.locale = new Locale(language);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
		return null;
	}

	private Locale locale;

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

	public String resetDatabase() {
		DaoFactory.setFactory(new DaoJpaFactory());
		DaoJpaFactory.dropAndCreateTables();
		LogManager.getLogger(clazz).debug("Reseteo de base de datos completo");
		return "home";
	}

}
