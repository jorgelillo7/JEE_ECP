package controllers;

import java.util.List;

import models.entities.Tema;
import models.entities.Voto;
import models.utils.NivelEstudios;
 
public interface VerVotacionesController {
	List<Tema> getListaTemas();
}
