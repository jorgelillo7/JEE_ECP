package controllers.ejbs;

import java.util.ArrayList;
import java.util.List;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.entities.Tema;
import models.entities.Voto;
import models.utils.NivelEstudios;
import controllers.AñadirVotoController;

public class AñadirVotoControllerEjb implements AñadirVotoController {

	@Override
	public boolean saveVoto(Voto voto, int idTema) {
		TemaDao temaDao = DaoFactory.getFactory().getTemaDao();
		Tema tema = temaDao.read(idTema);
		voto.setTema(tema);
		boolean result = false;
		if (voto != null) {
			DaoFactory.getFactory().getVotoDao().create(voto);
			result = true;
		}
		return result;
	}

	@Override
	public List<Tema> getListaTemas() {
		return DaoFactory.getFactory().getTemaDao().findAll();
	}

	@Override
	public List<NivelEstudios> getListaEstudios() {
		List<NivelEstudios> lista = new ArrayList<NivelEstudios>();

		NivelEstudios[] arrayNivel = NivelEstudios.values();
		for (NivelEstudios nivel : arrayNivel) {
			lista.add(nivel);
		}

		return lista;
	}

}
