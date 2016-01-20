package edu.emory.clinical.trials.webapp.server.rest;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import edu.emory.clinical.trials.webapp.server.rest.SmokeTest;

public class SmokeTestTest extends JerseyTest {
	
	@Test
	public void testEM() {
		String test = target("/test/em").request().get(String.class);
		assertEquals("EntityManager success!", test);
	}

	@Override
	protected Application configure() {
		return new ResourceConfig(SmokeTest.class);
	}
}