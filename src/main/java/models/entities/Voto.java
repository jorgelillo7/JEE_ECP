package models.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import models.utils.NivelEstudios;

@Entity
public class Voto {
	public static final String TABLE = "voto";
	public static final String ID = "ID";

	@Id
	@GeneratedValue
	private Integer id;

	public static final String NIVEL_ESTUDIOS = "NIVELESTUDIOS";
	@Enumerated(EnumType.STRING)
	private NivelEstudios nivelEstudios;

	public static final String IP = "IP";
	private String ip;

	public static final String VALORACION = "VALORACION";
	private int valoracion;
 
	public Voto(Integer id, NivelEstudios nivelEstudios, String ip, int valoracion) {
		super();
		this.id = id;
		this.nivelEstudios = nivelEstudios;
		this.ip = ip;
		this.valoracion = valoracion;
	}

	public Voto() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public NivelEstudios getNivelEstudios() {
		return nivelEstudios;
	}

	public void setNivelEstudios(NivelEstudios nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "Voto [id=" + id + ", nivelEstudios=" + nivelEstudios
				+ ", valoracion=" + valoracion + ", ip=" + ip + "]";
	}

}
