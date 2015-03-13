package models.daos.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
 
import models.daos.TemaDao;
import models.entities.Tema;

public class TemaDaoJdbc extends GenericDaoJdbc<Tema, Integer> implements
		TemaDao {
	private Logger log = LogManager.getLogger(TemaDaoJdbc.class);

	 private Tema create(ResultSet resultSet) {
	        try {
	            if (resultSet != null && resultSet.next()) {
	            	return new Tema(resultSet.getInt(Tema.ID), 
	                        resultSet.getString(Tema.PREGUNTA));
	            }
	        } catch (SQLException e) {
	            log.error("read: " + e.getMessage());
	        }
	        return null;
	    }


	private static final String SQL_CREATE_TABLE = "CREATE TABLE %s (%s INT, %s VARCHAR(255), PRIMARY KEY (%s))";

	public static String sqlToCreateTable() {
		return String.format(SQL_CREATE_TABLE, Tema.TABLE, Tema.ID,
				Tema.PREGUNTA, Tema.ID);
	}


    private static final String SQL_INSERT = "INSERT INTO %s (%s,%s) VALUES (%d,'%s')";

	@Override
	public void create(Tema tema) {
		this.updateSql(String.format(SQL_INSERT, Tema.TABLE,
				Tema.ID, Tema.PREGUNTA, tema.getId(), tema.getPregunta()));
	}

	@Override
	public Tema read(Integer id) {
		ResultSet resultSet = this.query(String.format(SQL_SELECT_ID,
				Tema.TABLE, id));
		return this.create(resultSet);
	}
	

    private static final String SQL_UPDATE = "UPDATE %s SET %s='%s' WHERE ID=%d";
	@Override
	public void update(Tema tema) {
		 this.updateSql(String.format(SQL_UPDATE, Tema.TABLE, Tema.PREGUNTA, tema.getPregunta(),
				 tema.getId()));

	}

	@Override
	public void deleteById(Integer id) {
	this.updateSql(String.format(SQL_DELETE_ID, Tema.TABLE, id));

	}

	@Override
	public List<Tema> findAll() {
		List<Tema> list = new ArrayList<Tema>();
        ResultSet resultSet = this.query(String.format(SQL_SELECT_ALL, Tema.TABLE));
        Tema tema = this.create(resultSet);
        while (tema != null) {
            list.add(tema);
            tema = this.create(resultSet);
        }
        return list;
	}

}
