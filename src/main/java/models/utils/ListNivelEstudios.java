package models.utils;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement; 
@XmlRootElement
public class ListNivelEstudios {

	private List<NivelEstudios> listNivel;

    public ListNivelEstudios(List<NivelEstudios> listNivel) {
        this.listNivel = listNivel;
    }

    public ListNivelEstudios() {
    }

    public List<NivelEstudios> getListNivel() {
        return listNivel;
    }

    public void setListNivel(List<NivelEstudios> listNivel) {
        this.listNivel = listNivel;
    }


}
