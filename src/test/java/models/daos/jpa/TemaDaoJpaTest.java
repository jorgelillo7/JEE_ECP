package models.daos.jpa;

import static org.junit.Assert.*;

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

	@Before
	public void before() {
		temaDaoJpa = DaoFactory.getFactory().getTemaDao();
		tema = new Tema("Ciencia","Tema 1");
		temaDaoJpa.create(tema);
	}

	@After
	public void after() {
		temaDaoJpa.deleteById(tema.getId());
	}

	@Test
	public void testCreate() {
		assertEquals("Objeto creado correctamente",
				temaDaoJpa.findAll().size(), 1);
	}

	@Test
	public void testRead() {
		assertEquals(temaDaoJpa.findAll().get(0).getPregunta(),
				tema.getPregunta());
	}

	@Test
	public void testUpdate() {
		String temaOriginal = tema.getPregunta();
		tema.setPregunta("Tema 2");
		temaDaoJpa.update(tema);
		assertNotEquals(temaDaoJpa.findAll().get(0).getPregunta(), temaOriginal);
	}

	@Test
	public void testDeleteById() {
		temaDaoJpa.deleteById(temaDaoJpa.findAll().get(0).getId());
		assertEquals(temaDaoJpa.findAll().size(), 0);
	}

	@Test
	public void testFindAll() {
		assertEquals(temaDaoJpa.findAll().size(), 1);
	}

}
