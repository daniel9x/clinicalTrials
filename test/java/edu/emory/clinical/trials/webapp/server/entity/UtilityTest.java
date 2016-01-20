package edu.emory.clinical.trials.webapp.server.entity;

import org.junit.BeforeClass;
import org.junit.Test;

import edu.emory.clinical.trials.webapp.server.LogUtil;
import edu.emory.clinical.trials.webapp.server.Util;
import edu.emory.clinical.trials.webapp.server.rest.RestServerConfigurator;

public class UtilityTest {

	@BeforeClass
	public static void setToTestMode() throws InstantiationException {
		Util.isTestMode = true;
		if (RestServerConfigurator.getInstance() == null) {
			RestServerConfigurator.init();
		};
	}

	@Test
	public void testJobLog() throws Exception {
		LogUtil.logJobResult("test", "test", true);
	}

	@Test
	public void testJobLogWithEmptyErrorMessage() throws Exception {
		LogUtil.logJobResult("test", "", true);
	}
}