package models.utils;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import models.entities.Tema;

@XmlRootElement
public class ListTemas {

	private List<Tema> listTemas;

	public ListTemas() {

	}

	public List<Tema> getListTemas() {
		return listTemas;
	}

	public void setListTemas(List<Tema> listTemas) {
		this.listTemas = listTemas;
	}

}
