package views.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;

import models.entities.Tema;
import models.entities.Voto;
import models.utils.NivelEstudios;
import controllers.ControllerFactory;

@ManagedBean
public class AñadirVotoView {
	@ManagedProperty(value = "#{controllerFactory}")
	private ControllerFactory controllerFactory;

	private String errorMsg;
	private String successMsg;

	public Tema tema;

	private Voto voto;

	private String ip;

	private NivelEstudios nivelEstudios;

	private Integer valoracion;

	private Integer idTema;

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

	public void setControllerFactory(ControllerFactory controllerFactory) {
		this.controllerFactory = controllerFactory;
	}

	public Integer getIdTema() {
		return idTema;
	}

	public void setIdTema(Integer idTema) {
		this.idTema = idTema;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public NivelEstudios getNivelEstudios() {
		return nivelEstudios;
	}

	public void setNivelEstudios(NivelEstudios nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
	}

	public Integer getValoracion() {
		return valoracion;
	}

	public void setValoracion(Integer valoracion) {
		this.valoracion = valoracion;
	}

	@PostConstruct
	public void updateView() {
		temas = this.controllerFactory.getAñadirVotoController()
				.getListaTemas();
		listaEstudios = this.controllerFactory.getAñadirVotoController()
				.getListaEstudios();
	}

	public String saveVoto() {
		if(this.ip == ""){
			HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			this.ip =  request.getRemoteAddr();
		}
	
		voto = new Voto(this.nivelEstudios, this.ip, this.valoracion);
		
		LogManager.getLogger(NuevoTemaView.class).debug(
				"Se accede a la capa de negocio para registrar voto: " + voto);

		controllerFactory.getAñadirVotoController().saveVoto(voto,
				this.getIdTema());
		return "home";

	}

}
