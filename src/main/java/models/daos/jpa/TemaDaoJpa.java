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
	        Root<Voto> rootTema= query.from(Voto.class);
	        query.select(rootTema);
	        Predicate p1 = criteria.equal(rootTema.get("tema").as(Tema.class), tema);
	        Predicate predicate = criteria.and(p1);
	        query.where(predicate);
	        TypedQuery<Voto> temaQuery = entityManager.createQuery(query);
	        return temaQuery.getResultList(); // Se buscan todos
	    }

	@Override
	public long countVotosByTema(Tema tema) {
		    entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
		    CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
	        CriteriaQuery<Long> criteriaQuery = criteria.createQuery(Long.class);
	        Root<Voto> rootTema = criteriaQuery.from(Voto.class);
	        Predicate p1 = criteria.equal(rootTema.get("tema").as(Tema.class), tema);
	        Predicate predicate = criteria.and(p1);
	        criteriaQuery.where(predicate);
	        criteriaQuery.select(criteria.count(rootTema));
	        TypedQuery<Long> longQuery = entityManager.createQuery(criteriaQuery);
	        return longQuery.getSingleResult();
	}

}
