package models.daos;

import java.util.List;

import models.entities.Tema;
import models.entities.Voto;

public interface TemaDao extends GenericDao<Tema, Integer> {
	List<Voto> findVotosByTema(Tema tema); 
}
