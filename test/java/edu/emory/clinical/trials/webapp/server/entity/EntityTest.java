package edu.emory.clinical.trials.webapp.server.entity;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class EntityTest {
	
	@Test
	public void testErmsStudyEntity() {
		ErmsStudy ermsStudy = new ErmsStudy();
		assertNotNull(ermsStudy);
	}
	
	@Test
	public void testLocationStagingEntity() {
		ClinicalTrialLocationStaging location = new ClinicalTrialLocationStaging();
		assertNotNull(location);
	}
	
	@Test
	public void testErmsStudyPrimaryKey() {
		ErmsStudyPrimaryKey ermsStudyPk = new ErmsStudyPrimaryKey();
		assertNotNull(ermsStudyPk);
	}
	

}
