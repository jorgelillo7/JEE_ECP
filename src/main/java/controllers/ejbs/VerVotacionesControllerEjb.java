package controllers.ejbs;

import java.util.ArrayList;
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

	@Override
	public List<Long> getNumeroVotos() {
		List<Long> listaVotos = new ArrayList<Long>();
		List<Tema> temas = DaoFactory.getFactory().getTemaDao().findAll();
		
		long count = 0;
		for (Tema tema : temas) {
			count = DaoFactory.getFactory().getTemaDao().countVotosByTema(tema);
			listaVotos.add(count);
		}
		return listaVotos;
	}
	


}
