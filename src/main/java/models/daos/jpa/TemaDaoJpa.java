package models.daos.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
 

import org.apache.logging.log4j.LogManager;

import models.daos.TemaDao;
import models.entities.Tema;
import models.entities.Voto;

public class TemaDaoJpa extends GenericDaoJpa<Tema, Integer> implements TemaDao {
	private EntityManager entityManager;
	
	public TemaDaoJpa() {
		super(Tema.class);
	}
	
	 public List<Voto> findVotosByTema(Tema tema) { 
		    entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
	        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
	        CriteriaQuery<Voto> query = criteria.createQuery(Voto.class);
	        Root<Voto> rootPhone = query.from(Voto.class);
	        query.select(rootPhone);
	        Predicate p1 = criteria.equal(rootPhone.get("tema").as(Tema.class), tema);
	        Predicate predicate = criteria.and(p1);
	        query.where(predicate);
	        TypedQuery<Voto> phoneQuery = entityManager.createQuery(query);
	        return phoneQuery.getResultList(); // Se buscan todos
	    }

}
