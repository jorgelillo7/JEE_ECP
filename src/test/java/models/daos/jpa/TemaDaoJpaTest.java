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
		temaDaoJpa.deleteById(tema.getId());
	}
	
	@Test
	public void testRead() {
		temaDaoJpa = DaoFactory.getFactory().getTemaDao();
		tema = new Tema("Tema 1");
		temaDaoJpa.create(tema);
		assertEquals(temaDaoJpa.findAll().get(0).getPregunta(),tema.getPregunta());
		temaDaoJpa.deleteById(tema.getId());
	}
	
	@Test
	public void testUpdate() {
		
	}

	@Test
	public void testDeleteById() {
		temaDaoJpa = DaoFactory.getFactory().getTemaDao();
		tema = new Tema("Tema 1");
		temaDaoJpa.create(tema);
		temaDaoJpa.deleteById(temaDaoJpa.findAll().get(0).getId());
		assertEquals(temaDaoJpa.findAll().size(), 0);		
	}

	@Test
	public void testFindAll() {
		temaDaoJpa = DaoFactory.getFactory().getTemaDao();
		tema = new Tema("Tema 1");
		temaDaoJpa.create(tema);
		assertEquals(temaDaoJpa.findAll().size(), 1);	
		temaDaoJpa.deleteById(tema.getId());
	}
	
	
	
	
}
