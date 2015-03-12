package models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tema {
	public static final String TABLE = "tema";

	public static final String ID = "ID";

	@Id
	@GeneratedValue
	private Integer id;

	public static final String PREGUNTA = "PREGUNTA";
	private String pregunta;

	public Tema() {
	}

	public Tema(String pregunta) {
		super();
		this.pregunta = pregunta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	@Override
	public String toString() {
		return "Tema [id=" + id + ", pregunta=" + pregunta + "]";
	}

}
