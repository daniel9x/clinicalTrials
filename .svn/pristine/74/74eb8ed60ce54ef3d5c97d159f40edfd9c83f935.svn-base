package edu.emory.clinical.trials.webapp.server.job;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import edu.emory.clinical.trials.webapp.server.ClinicalTrialsDataExtractor;
import edu.emory.clinical.trials.webapp.server.LogUtil;

public class ClinicalTrialsDataExtractorJob implements Job {

	private Logger logger = Logger.getLogger(ClinicalTrialsDataExtractorJob.class.getName());

	public void execute(JobExecutionContext context) throws JobExecutionException {

		try {
			ClinicalTrialsDataExtractor ctExtract = new ClinicalTrialsDataExtractor();
			ctExtract.extract();	
			LogUtil.logJobResult("ClinicalTrialsDataExtractJob","", true);
		}
		catch (Exception e) {
			try {
				LogUtil.logJobResult("ClinicalTrialsDataExtractJob",e.getMessage(), false);
			} catch (Exception e1) {
				logger.error(e1);
			}
			logger.error("ERROR:", e);
			throw new JobExecutionException(e);
		}

	}
}