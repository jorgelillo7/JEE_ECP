package models.daos.jpa;

import static org.junit.Assert.*;

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

public class TemaDaoJpaTest {
	public TemaDao temaDaoJpa;
	public VotoDao votoDaoJpa;

	private Tema tema;
	private Voto voto;
	private Voto voto2;

	@BeforeClass
	public static void beforeClass() {
		DaoFactory.setFactory(new DaoJpaFactory());
		DaoJpaFactory.dropAndCreateTables();
	}

	@Before
	public void before() {
		temaDaoJpa = DaoFactory.getFactory().getTemaDao();
		votoDaoJpa = DaoFactory.getFactory().getVotoDao();
		tema = new Tema("Ciencia", "Tema 1");
		voto = new Voto(NivelEstudios.Master, "192.167.1.4", 5, tema);
		voto2 = new Voto(NivelEstudios.Master, "127.0.0.1", 8, tema);
		temaDaoJpa.create(tema);
		votoDaoJpa.create(voto);
		votoDaoJpa.create(voto2);
	}

	@After
	public void after() {
		List<Voto> listaVotosAsociado = temaDaoJpa.findVotosByTema(tema);

		for (Voto voto : listaVotosAsociado) {
			votoDaoJpa.deleteById(voto.getId());
		}

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
		List<Voto> listaVotosAsociado = temaDaoJpa.findVotosByTema(tema);

		for (Voto voto : listaVotosAsociado) {
			votoDaoJpa.deleteById(voto.getId());
		}
		
		temaDaoJpa.deleteById(tema.getId());
		assertEquals(temaDaoJpa.findAll().size(), 0);
	}

	@Test
	public void testFindAll() {
		assertEquals(temaDaoJpa.findAll().size(), 1);
	}

	@Test
	public void testGetVotosByTema() {
		List<Voto> lista = (temaDaoJpa.findVotosByTema(tema));
		assertEquals(lista.size(), 2);
	}
	
	@Test
	public void testCountVotosByTema() {
		long count = (temaDaoJpa.countVotosByTema(tema));
		assertEquals(count, 2);
	}
	
	@Test
	public void testGetVotosByTemaYNivel() {
		List<Voto> votos = (temaDaoJpa.findVotosByTemaAndNivel(tema, NivelEstudios.Master));
		assertEquals(votos.size(), 2);
	}
	
	
}
