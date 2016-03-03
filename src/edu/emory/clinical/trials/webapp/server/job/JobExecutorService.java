package edu.emory.clinical.trials.webapp.server.job;

import javax.ejb.Schedule;
import javax.ejb.Singleton;

import org.apache.log4j.Logger;

import edu.emory.clinical.trials.webapp.server.ClinicalTrialsDataExtractor;
import edu.emory.clinical.trials.webapp.server.LogUtil;

@Singleton
public class JobExecutorService {

	private Logger logger = Logger.getLogger(JobExecutorService.class.getName());

	@Schedule(second = "0", minute = "0", hour = "1",persistent = false)
	public void executeDataExtractJob() throws Exception {
		if (new ClinicalTrialsDataExtractor().extract()) {
			LogUtil.logJobResult("ClinicalTrialsDataExtractJob", true);
			logger.info("Extract Job Completed Successfully.");
		} else {
			LogUtil.logJobResult("ClinicalTrialsDataExtractJob", false);
		}
	}
}
