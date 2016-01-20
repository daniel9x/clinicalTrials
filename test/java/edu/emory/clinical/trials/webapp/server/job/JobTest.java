package edu.emory.clinical.trials.webapp.server.job;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class JobTest {
	
	@Test
	public void testJobExecutorService() {
		JobExecutorService service = new JobExecutorService();
		assertNotNull(service);
	}
	
	@Test
	public void testClinicalTrialsDataExtractorJob() {
		ClinicalTrialsDataExtractorJob job = new ClinicalTrialsDataExtractorJob();
		assertNotNull(job);
	}
	
	@Test
	public void testJobWithNullContext() throws Exception {
		ClinicalTrialsDataExtractorJob job = new ClinicalTrialsDataExtractorJob();
		job.execute(null);
	}
	
}
