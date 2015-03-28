package controllers;

import java.util.List;

import models.entities.Tema;
import models.entities.Voto;
import models.utils.NivelEstudios;

public interface AñadirVotoController {

	boolean saveVoto(Voto voto, int idTema);

	List<Tema> getListaTemas();

	List<NivelEstudios> getListaEstudios();

}
