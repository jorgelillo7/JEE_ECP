package models.utils;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListLong {

	private List<Long> listLong;

	public ListLong() {

	}

	public List<Long> getListLong() {
		return listLong;
	}

	public void setListLong(List<Long> listLong) {
		this.listLong = listLong;
	}

}
