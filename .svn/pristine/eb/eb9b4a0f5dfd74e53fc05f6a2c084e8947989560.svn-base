package edu.emory.clinical.trials.webapp.server.rest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.emory.clinical.trials.webapp.server.entity.SearchResultView;


public class HibernateTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinicalTrialsEntityManagerLocal");

		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("select s from SearchResultView s where lower(s.studyStatus) = 'active'");
		
		List<SearchResultView> searchResults = query.getResultList();
		
		System.out.println(searchResults.size());
		
		
	}

}
