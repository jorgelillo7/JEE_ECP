package models.daos;

import java.util.List;
import models.entities.Tema;
import models.entities.Voto;
import models.utils.NivelEstudios;

public interface TemaDao extends GenericDao<Tema, Integer> {
	List<Voto> findVotosByTema(Tema tema); 
	long countVotosByTema(Tema tema); 
	List<Voto> findVotosByTemaAndNivel(Tema tema, NivelEstudios nivel); 
}
