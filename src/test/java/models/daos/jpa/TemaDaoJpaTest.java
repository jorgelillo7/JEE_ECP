package models.daos.jpa;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.entities.Tema;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test; 

public class TemaDaoJpaTest { 
	public TemaDao temaDaoJpa;

	private Tema tema;

	@BeforeClass
	public static void beforeClass() {
		DaoFactory.setFactory(new DaoJpaFactory());
		DaoJpaFactory.dropAndCreateTables();
	}
	
	@Test
	public void testCreate() {
		temaDaoJpa = DaoFactory.getFactory().getTemaDao();
		tema = new Tema("Tema 1");
		temaDaoJpa.create(tema);
		assertEquals("Objeto creado correctamente", temaDaoJpa.findAll().size(), 1);
		
		// Revisar añadir fk a voto
	}
}
