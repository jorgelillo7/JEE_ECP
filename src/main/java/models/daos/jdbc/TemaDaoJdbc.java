package models.daos.jdbc;

import java.util.List;

import models.daos.TemaDao;
import models.entities.Tema;
import models.entities.Voto;

public class TemaDaoJdbc extends GenericDaoJdbc<Tema, Integer> implements
		TemaDao {

	private static final String SQL_CREATE_TABLE = "CREATE TABLE %s (%s INT NOT NULL, %s VARCHAR(255), "
			+ "%s VARCHAR(255), PRIMARY KEY (%s))";

	public static String sqlToCreateTable() {
		return String.format(SQL_CREATE_TABLE, Voto.TABLE, Voto.ID,
				Tema.PREGUNTA);
	}

	@Override
	public void create(Tema entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Tema read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Tema entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Tema> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
