package models.utils;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Medias")
public class ListMedias {

	private List<List<String>> listMedias;

	public ListMedias() {

	}

	public List<List<String>> getListMedia() {
		return listMedias;
	}

	public void setListMedia(List<List<String>> listMedias) {
		this.listMedias = listMedias;
	}

}
