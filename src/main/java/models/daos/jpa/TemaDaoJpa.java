package models.daos.jpa;

import models.daos.TemaDao;
import models.entities.Tema;

public class TemaDaoJpa extends GenericDaoJpa<Tema, Integer> implements TemaDao {

	public TemaDaoJpa() {
		super(Tema.class);
	}

}
