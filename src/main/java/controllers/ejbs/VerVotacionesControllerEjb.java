package controllers.ejbs;

import java.util.List;

import models.daos.DaoFactory;
import models.entities.Tema;
import models.utils.NivelEstudios;
import controllers.VerVotacionesController;

public class VerVotacionesControllerEjb implements VerVotacionesController {

	
	@Override
	public List<Tema> getListaTemas() {
		return DaoFactory.getFactory().getTemaDao().findAll();
	}
	


}
