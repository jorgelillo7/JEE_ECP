package models.daos.jpa;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.VotoDao;
import models.entities.Tema;
import models.entities.Voto;
import models.utils.NivelEstudios;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VotoDaoJpaTest {
	public VotoDao votoDaoJpa;
  
	private Voto voto;
	private Tema tema;
	
	@BeforeClass
	public static void beforeClass() {
		DaoFactory.setFactory(new DaoJpaFactory());
		DaoJpaFactory.dropAndCreateTables();
	}

	@Before
	public void before() {
		votoDaoJpa = DaoFactory.getFactory().getVotoDao();
		tema = new Tema("Tema 1");
		voto = new Voto(NivelEstudios.Master, "192.167.1.4", 5, tema);
		votoDaoJpa.create(voto);
	} 

	@After
	public void after() {
		votoDaoJpa.deleteById(voto.getId());
	}

	@Test
	public void testCreate() {
		assertEquals("Objeto creado correctamente",	votoDaoJpa.findAll().size(), 1);
	}
	
	
	@Test
	public void testRead() {
		assertEquals(voto.getId(), votoDaoJpa.read(voto.getId()).getId());
		
	}

	@Test
	public void testUpdate() {
		String ipOriginal = voto.getIp();
		voto.setIp("172.192.1.2");
		votoDaoJpa.update(voto);
		assertNotEquals(ipOriginal, voto.getIp());
		
	}

	@Test
	public void testDeleteById() {
		votoDaoJpa.deleteById(voto.getId());
		assertNull(votoDaoJpa.read(voto.getId()));
		
	}

	@Test
	public void testFindAll() {
		assertEquals(1, votoDaoJpa.findAll().size());
	}
	
}
