package edu.emory.clinical.trials.webapp.server.rest;

import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.emory.clinical.trials.webapp.server.rest.TestConfigurator;
import edu.emory.clinical.trials.webapp.server.rest.RestServerConfigurator;

@Path("test")
public class SmokeTest {

	EntityManager em;

	public SmokeTest() {

		if (RestServerConfigurator.getInstance() != null) {
			em = RestServerConfigurator.getInstance().getEmf().createEntityManager();
		}
		// Use Test EMF
		else {
			em = TestConfigurator.getInstance().getEmf().createEntityManager();
		}
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test() throws Exception {
		return "Works!";
	}

	@GET
	@Path("/em")
	@Produces(MediaType.TEXT_PLAIN)
	public String testEntityManager() throws Exception {
		em.createQuery("select count(s) from SearchResultView s");
		em.close();
		return "EntityManager success!";
	}

}
