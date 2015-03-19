package models.daos.jdbc;

import static org.junit.Assert.*;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.entities.Tema;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TemaDaoJdbcTest {
	public TemaDao temaDaoJdbc;

	private Tema tema;

	@BeforeClass
	public static void beforeClass() {
		DaoFactory.setFactory(new DaoJdbcFactory());
		DaoJdbcFactory.dropAndCreateTables();
	}

	@Before
	public void before() {
		temaDaoJdbc = DaoFactory.getFactory().getTemaDao();
		tema = new Tema(13, "Ciencia", "Tema 1");
		temaDaoJdbc.create(tema);
	}

	@After
	public void after() {
		temaDaoJdbc.deleteById(tema.getId());
	}

	@Test
	public void testCreate() {
		assertEquals("Objeto creado correctamente", temaDaoJdbc.findAll()
				.size(), 1);
	}

	@Test
	public void testRead() {
		assertEquals(temaDaoJdbc.findAll().get(0).getPregunta(),
				tema.getPregunta());
	}

	@Test
	public void testUpdate() {
		String temaOriginal = tema.getPregunta();
		tema.setPregunta("Tema 2");
		temaDaoJdbc.update(tema);
		assertNotEquals(temaDaoJdbc.findAll().get(0).getPregunta(),
				temaOriginal);
	}

	@Test
	public void testDeleteById() {
		temaDaoJdbc.deleteById(temaDaoJdbc.findAll().get(0).getId());
		assertEquals(temaDaoJdbc.findAll().size(), 0);
	}

	@Test
	public void testFindAll() {
		assertEquals(temaDaoJdbc.findAll().size(), 1);
	}

}
