package edu.emory.clinical.trials.webapp.server;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

import edu.emory.clinical.trials.webapp.server.rest.RestApplication;

public class InitTest {
	
	@BeforeClass
	public static void setToTestMode() {
		Util.isTestMode = true;
	}
	
	@Test
	public void testRestApplication() throws InstantiationException {
		RestApplication restApplication = new RestApplication();
		assertNotNull(restApplication);
	}

}
