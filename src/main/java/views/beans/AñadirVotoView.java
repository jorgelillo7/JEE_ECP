package views.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;

import models.entities.Tema;
import models.entities.Voto;
import models.utils.NivelEstudios;
import controllers.ControllerFactory;

@ManagedBean
public class AñadirVotoView {
	private ControllerFactory controllerFactory;

	private String errorMsg;
	private String successMsg;

	public Integer idTema;

	public Tema tema;
	
	private Voto voto;
	
	public List<NivelEstudios> listaEstudios;
	
	public List<NivelEstudios> getListaEstudios() {
		return listaEstudios;
	}

	public void setListaEstudios(List<NivelEstudios> listaEstudios) {
		this.listaEstudios = listaEstudios;
	}
	
	
	public List<Tema> temas;

	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}
	
	public Voto getVoto() {
		return voto;
	}

	public void setVoto(Voto voto) {
		this.voto = voto;
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


	public Integer getIdTema() {
		return idTema;
	}

	public void setIdTema(Integer idTema) {
		this.idTema = idTema;
	}

	public void setControllerFactory(ControllerFactory controllerFactory) {
		this.controllerFactory = controllerFactory;
	}

	
	public void mostrarListaTemas() {
		temas = this.controllerFactory.getAñadirVotoController()
				.getListaTemas();
	}

	public void mostrarListaEstudios() {
		listaEstudios = this.controllerFactory.getAñadirVotoController()
				.getListaEstudios();
	}

	public String saveVoto(Voto voto) {
		LogManager.getLogger(NuevoTemaView.class).debug(
				"Se accede a la capa de negocio para registrar voto: " + voto);

		
		controllerFactory.getAñadirVotoController().saveVoto(voto, this.getIdTema());
		return "home";

	}
	

}
