package models.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Tema implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String TABLE = "tema";
	public static final String ID = "ID";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// auto increment
	private Integer id;

	public static final String PREGUNTA = "PREGUNTA";
	private String pregunta;

	public static final String CATEGORIA = "CATEGORIA";
	private String categoria;

	public Tema(Integer id, String categoria, String pregunta) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.pregunta = pregunta;
	}

	public Tema(String categoria, String pregunta) {
		super();
		this.categoria = categoria;
		this.pregunta = pregunta;
	}

	public Tema() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public boolean equals(Object obj) {
		assert obj != null;
		Tema other = (Tema) obj;
		return id.equals(other.id) && categoria.equals(other.categoria)
				&& pregunta.equals(other.pregunta);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result
				+ ((pregunta == null) ? 0 : pregunta.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return categoria + " - " + pregunta;
	}

}
