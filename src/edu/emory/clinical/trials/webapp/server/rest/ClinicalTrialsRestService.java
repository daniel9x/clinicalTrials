package edu.emory.clinical.trials.webapp.server.rest;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.glassfish.jersey.server.JSONP;

import edu.emory.clinical.trials.webapp.server.ClinicalTrialsDataExtractor;
import edu.emory.clinical.trials.webapp.server.Util;
import edu.emory.clinical.trials.webapp.server.entity.ClinicalTrialIntervention;
import edu.emory.clinical.trials.webapp.server.entity.ErmsStudyCRC;
import edu.emory.clinical.trials.webapp.server.entity.SearchResultView;
import edu.emory.clinical.trials.webapp.server.entity.TrialCategory;
import edu.emory.clinical.trials.webapp.server.entity.TrialDetail;

/**
 * Returning JSONP via these methods is considered a hack to get around a security holy in the HTTP protocol. 
 * This isn't a current threat, but it might be wise to explore other alternatives in the future.
 * 
 * Root resource (exposed at "myresource" path)
 */
@Path("trials")
@SuppressWarnings("unchecked")
public final class ClinicalTrialsRestService {

	private final EntityManagerFactory emf;

	private static Logger logger = Logger.getLogger(ClinicalTrialsDataExtractor.class.getName());

	public ClinicalTrialsRestService() {
		if (RestServerConfigurator.getInstance() != null && !Util.isTestMode) {
			emf = RestServerConfigurator.getInstance().getEmf();
		}
		// Using Test
		else {
			emf = TestConfigurator.getInstance().getEmf();
		}
	}

	@GET
	@JSONP(callback = "searchResults")
	@Path("/search")
	@Produces("application/javascript")
	public List<SearchResultView> getResults(
			@QueryParam("criteria") String criteria,
			@QueryParam("status") String status) throws Exception {

		String statusClause = "";

		if (status != null) {
			status = status.toLowerCase();
			statusClause = " AND lower(S.STUDY_STATUS) = '" + status + "'";
		}

		String nativeQuery = "SELECT DISTINCT S.* "
				+ "FROM SEARCH_RESULTS_VIEW S "
				+ "LEFT OUTER JOIN CT_KEYWORD K "
				+ "ON K.NCT_ID = S.NCT_ID "
				+ "LEFT OUTER JOIN CT_MESH_TERM M "
				+ "ON M.NCT_ID = S.NCT_ID "
				+ "WHERE (S.BRIEF_SUMMARY LIKE '%:searchCriteria%' "
				+ "OR lower(S.BRIEF_TITLE) LIKE '%:searchCriteria%' "
				+ "OR lower(S.CONDITION) LIKE '%:searchCriteria%' "
				+ "OR lower(S.DEPT_DIV) LIKE '%:searchCriteria%' "
				+ "OR lower(S.DEPT_DIV_ID) LIKE '%:searchCriteria%' "
				+ "OR lower(S.ERMS_STUDY_ID) LIKE '%:searchCriteria%' "
				+ "OR lower(S.NCT_ID) LIKE '%:searchCriteria%' "
				+ "OR lower(S.PI_NAME) LIKE '%:searchCriteria%' "
				+ "OR lower(S.PRIMARY_CATEGORY) LIKE '%:searchCriteria%' "
				+ "OR lower(S.SECONDARY_CATEGORY) LIKE '%:searchCriteria%' "
				+ "OR lower(S.STUDY_STATUS) LIKE '%:searchCriteria%' "
				+ "OR lower(K.KEYWORD) LIKE '%:searchCriteria%' "
				+ "OR lower(M.TERM) LIKE '%:searchCriteria%')"
				+ statusClause
				+ "ORDER BY S.STUDY_STATUS_SORT_ORDER,S.NCT_ID desc";

		EntityManager em = emf.createEntityManager();

		if (criteria != null) {
			if (criteria.toLowerCase().contains("alzheimer's") || criteria.toLowerCase().contains("alzeheimer's") || criteria.toLowerCase().contains("alzeheimers")) {
				criteria = "alzheimer";
			}
			else if (criteria.toLowerCase().contains("'s")) {
				criteria = criteria.replace("'s","");
			}
		}

		try {
			
			if (criteria != null) {
				criteria = criteria.toLowerCase();
				nativeQuery = nativeQuery.replaceAll(":searchCriteria", criteria);
			}
			else {
				nativeQuery = nativeQuery.replaceAll(":searchCriteria", "");
			}

			List<SearchResultView> searchResults = (List<SearchResultView>)em.createNativeQuery(nativeQuery, edu.emory.clinical.trials.webapp.server.entity.SearchResultView.class).getResultList();

			logger.debug("Search Criteria: " + criteria + " -- " + searchResults.size() + " Results Returned.");

			return searchResults;

		}

		catch (Exception e){
			logger.error(e.getMessage(),e);
			throw new Exception(e);
		}

		finally {
			em.close();
		}

	}

	@GET
	@Path("/query")
	@JSONP(callback="searchResults")
	@Produces("application/javascript")
	public List<SearchResultView> getNct(
			@QueryParam("callback") String callback,
			@QueryParam("nctId") String nctId,
			@QueryParam("category") String category,
			@QueryParam("condition") String condition,
			@QueryParam("status") String status) throws Exception {

		EntityManager em = emf.createEntityManager();

		try {

			List<String> filters = new ArrayList<String>();

			if (nctId != null) {
				filters.add("lower(s.primaryKey.nctId) = :nctId");
			}

			if (category != null) {
				filters.add("(lower(s.primaryCategory) like :primaryCategory or lower(s.secondaryCategory) like :secondaryCategory)");
			}

			if (condition != null) {
				filters.add("lower(condition) like :condition");
			}

			if (status != null) {
				status = status.toLowerCase();
				filters.add("lower(s.studyStatus) like :status");
			}

			String whereClause = "";
			if (!filters.isEmpty()) {
				whereClause = " where " + StringUtils.join(filters, " and ");
			}
			else {
				throw new IllegalArgumentException();
			}

			Query query = em.createQuery("select s from SearchResultView s " + whereClause);

			if (nctId != null) {
				query.setParameter("nctId", nctId.toLowerCase());
			}

			if (category != null) {
				category = category.toLowerCase();
				query.setParameter("primaryCategory", "%" + category + "%");
				query.setParameter("secondaryCategory", "%" + category + "%");
			}

			if (condition != null) {
				query.setParameter("condition", "%" + condition.toLowerCase() +"%");
			}

			if (status != null) {
				query.setParameter("status", "%" + status.toLowerCase() +"%");
			}

			List<SearchResultView> searchResults = query.getResultList();

			return searchResults;
		}
		catch (IllegalArgumentException e) {
			logger.error(e);
			logger.error("/query endpoint requires one (or more) of the 4 parameters (case sensetive): nctId,category,condition,status");	
			return null;
		}
		catch (Exception e){
			logger.error(e.getMessage(),e);
			throw new Exception(e);
		}
		finally {
			em.close();
		}
	}

	@GET
	@Path("/total")
	@JSONP(callback="callback-PaaS")
	@Produces("application/javascript")
	public String getTotal(@QueryParam("callback") String callback,
			@QueryParam("status") String status) throws Exception {

		EntityManager em = emf.createEntityManager();

		try {

			String whereClause = "";

			if (status != null) {
				status = status.toLowerCase();
				whereClause = "where lower(s.studyStatus) = :status";
			}

			Query query = em.createQuery("select count(s.primaryKey.nctId) from SearchResultView s " + whereClause);

			if (status != null) {
				status = status.toLowerCase();
				query.setParameter("status", status);
			}

			Long count = (Long)query.getSingleResult();

			return "{\"total\":\"" + count + "\"}";
		}
		catch (Exception e){
			logger.error(e.getMessage(),e);
			throw new Exception(e);
		}
		finally {
			em.close();
		}
	}

	@GET
	@Path("/categories")
	@JSONP(callback="categories")
	@Produces("application/javascript")
	public List<TrialCategory> getCategories(@QueryParam("callback") String callback) throws Exception {

		EntityManager em = emf.createEntityManager();

		try {

			Query query = em.createQuery("select c from TrialCategory c ");

			List<TrialCategory> trialCategories = query.getResultList();

			return trialCategories;
		}
		catch (Exception e){
			logger.error(e.getMessage(),e);
			throw new Exception(e);
		}
		finally {
			em.close();
		}
	}

	@GET
	@Path("/detail")
	@JSONP
	@Produces("application/javascript")
	public TrialDetail getStudyDetail(
			@QueryParam("nctId") String nctId,
			@QueryParam("studyId") Integer studyId) throws Exception {

		EntityManager em = emf.createEntityManager();

		try {

			Query query = em.createQuery("select distinct s from SearchResultView s where lower(s.primaryKey.nctId) = :nctId and s.primaryKey.studyId = :studyId");

			if (nctId != null) {
				nctId = nctId.toLowerCase();
				query.setParameter("nctId", nctId);
			}

			if (studyId != null) {
				query.setParameter("studyId", studyId);
			}

			if (studyId == null || nctId == null) {
				throw new IllegalArgumentException();
			}

			SearchResultView searchResult = (SearchResultView)query.getSingleResult();

			TrialDetail detailResult = new TrialDetail(searchResult);

			query = em.createQuery("select distinct i from ClinicalTrialIntervention i where lower(i.nctId) = :nctId");

			if (nctId != null) {
				nctId = nctId.toLowerCase();
				query.setParameter("nctId", nctId);
			}

			List<ClinicalTrialIntervention> interventions = query.getResultList();

			if (interventions != null) {
				detailResult.setInterventions(interventions);
			}

			query = em.createQuery("select distinct crc from ErmsStudyCRC crc where crc.studyId = :studyId");

			if (studyId != null) {
				query.setParameter("studyId", studyId);
			}

			List<ErmsStudyCRC> clinicalResearchCoordinators = query.getResultList();

			if (clinicalResearchCoordinators != null) {
				detailResult.setClinicalResearchCoordinators(clinicalResearchCoordinators);
			}

			return detailResult;
		}
		catch (NoResultException e) {
			logger.error(e);
			logger.error("Either the nctId or the studyId (or the passed in combination) does not exist in the database.");
			return null;
		}
		catch (IllegalArgumentException e) {
			logger.error(e);
			logger .error("studyId and nctId parameters are required for the API /detail endpoint");	
			return null;
		}
		catch (Exception e){
			logger.error(e.getMessage(),e);
			throw new Exception(e);
		}

	}
	
	@GET
	@Path("/test")
	@Produces("text/html") 
	public String getTest() {
		return "<html class='dark'>"
			 + "<h1>"
			 + "<center>"
			 + "<link rel=\"stylesheet\" type=\"text/css\" href=\"../../style.css\">"
			 + "<center>"
			 + "<div class='fun'>"
			 + "<span>"
			 + "<center>This is the ClinicalTrials Test Page.</center>"
			 + "</span>"
			 + "</div>"
			 + "</html>";
	}
}
