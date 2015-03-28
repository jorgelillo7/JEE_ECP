package controllers.ejbs;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import models.daos.DaoFactory;
import models.entities.Tema;
import models.entities.Voto;
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

	@Override
	public List<NivelEstudios> getListaNivelEstudios() {
		List<NivelEstudios> lista = new ArrayList<NivelEstudios>();

		NivelEstudios[] arrayNivel = NivelEstudios.values();
		for (NivelEstudios nivel : arrayNivel) {
			lista.add(nivel);
		}
		return lista;
	}

	@Override
	public List<List<String>> getListaMedia() {
		List<Tema> temas = this.getListaTemas();
		List<NivelEstudios> listaEstudios = this.getListaNivelEstudios();

		List<List<String>> listaNivelesPorTema = new ArrayList<List<String>>();
		List<String> mediaListNivel;

		for (int i = 0; i < temas.size(); i++) {
			Tema tema = temas.get(i);
			int votosPorPregunta = 0;
			mediaListNivel = new ArrayList<String>();

			for (int j = 0; j < listaEstudios.size(); j++) {
				NivelEstudios nivel = listaEstudios.get(j);

				// cambiar por get votos por nivel y pregunta
				List<Voto> votosPorPreguntaYNivel = DaoFactory.getFactory()
						.getTemaDao().findVotosByTemaAndNivel(tema, nivel);

				votosPorPregunta = votosPorPreguntaYNivel.size();
				int sumaValoraciones = 0;

				for (Voto voto : votosPorPreguntaYNivel) {
					sumaValoraciones += voto.getValoracion();
				}
				String mediaString = "";
				if (votosPorPregunta > 0) {
					double media = (double) sumaValoraciones
							/ (double) votosPorPregunta;
					DecimalFormat df = new DecimalFormat("0.00");
					mediaString = String.valueOf(df.format(media))
							+ " (Total: " + votosPorPregunta + ")";

				} else {
					mediaString = "0";
				}

				mediaListNivel.add(mediaString);
			}
			listaNivelesPorTema.add(mediaListNivel);

		}

		return listaNivelesPorTema;
	}

}
