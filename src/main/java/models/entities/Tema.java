package models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tema {
	public static final String TABLE = "tema";
	public static final String ID = "ID";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  //auto increment
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
	public String toString() {
		return "Tema [id=" + id + ", categoria=" + categoria + ", pregunta=" + pregunta + "]";
	}


}
