package edu.emory.clinical.trials.webapp.server.job;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.apache.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;

@Singleton
@Startup
public class JobExecutorService {

	JobDetail jobDetail;
	
	private Logger logger = Logger.getLogger(JobExecutorService.class.getName());

	@PostConstruct
	public void scheduleJobs() {
		try {
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			
			jobDetail = JobBuilder.newJob(ClinicalTrialsDataExtractorJob.class).withIdentity("ClinicalTrials-DataExtractionJob",StdScheduler.DEFAULT_GROUP).build();
			
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("ClinicalTrialsDataExtractionJob").withSchedule(CronScheduleBuilder.cronSchedule("0 0 1 * * ?")).build();
			
			scheduler.scheduleJob(jobDetail, trigger);
			scheduler.start();

		} catch (JobExecutionException e) {
			logger.error(e);
		}
		catch (Exception e) {  
			logger.error(e);
		}
	}

}
