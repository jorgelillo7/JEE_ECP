package controllers.ejbs;

import models.daos.DaoFactory;
import models.entities.Tema;
import controllers.NuevoTemaController;

public class NuevoTemaControllerEjb implements NuevoTemaController{

	@Override
	public boolean saveTema(Tema tema) {
	       boolean result = false;
	        if (tema != null) {
	            DaoFactory.getFactory().getTemaDao().create(tema);
	            result = true;
	        }
	        return result;
	}

}
