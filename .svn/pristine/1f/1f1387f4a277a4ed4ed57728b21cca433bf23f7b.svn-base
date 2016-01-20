package edu.emory.clinical.trials.webapp.server;

import org.junit.Test;

public class EmailManagerTest {
	
	@Test
	public void testExtractFailureEmail() throws Exception {
		Util.isTestMode = true;
		new EmailManager().sendExtractFailureEmail(new Exception());
	}

}
