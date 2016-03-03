package edu.emory.clinical.trials.webapp.server;

import java.util.Date;

import javax.persistence.EntityManager;

import edu.emory.clinical.trials.webapp.server.entity.JobLog;
import edu.emory.clinical.trials.webapp.server.rest.RestServerConfigurator;

public class LogUtil {

	public static void logJobResult(String jobName, Boolean success) throws Exception {
		JobLog jobLog = new JobLog();
		jobLog.setJobName(jobName);
		jobLog.setJobCompletionDate(new Date());
		if (success) {
			jobLog.setSuccessFlag('Y');
		} else {
			jobLog.setSuccessFlag('Y');
		}
		persistLog(jobLog);
	}

	private static void persistLog(JobLog jobLog) throws Exception {
		EntityManager em = RestServerConfigurator.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		Delegator.persistToDatabase(em, jobLog);
		em.getTransaction().commit();
		em.close();
	}
}
