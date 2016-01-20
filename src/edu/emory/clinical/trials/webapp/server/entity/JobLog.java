package edu.emory.clinical.trials.webapp.server.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "job_log")
public class JobLog {
	
	
	@Id
	@GeneratedValue(generator="sq_job_log")
	@SequenceGenerator(name="sq_job_log", sequenceName="sq_job_log")
	@Column(name = "job_log_id")
	private Integer jobLogId;
	
	@Column(name = "job_name")
	private String jobName;
	
	@Column(name = "job_completion_date")
	private Date jobCompletionDate;
	
	@Column(name = "success_flag")
	private Character successFlag;
	
	@Column(name = "cause_of_failure")
	private String causeOfFailure;

	public void setJobLogId(Integer jobLogId) {
		this.jobLogId = jobLogId;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public void setJobCompletionDate(Date jobCompletionDate) {
		this.jobCompletionDate = jobCompletionDate;
	}

	public void setSuccessFlag(Character successFlag) {
		this.successFlag = successFlag;
	}

	public void setCauseOfFailure(String causeOfFailure) {
		this.causeOfFailure = causeOfFailure;
	}

}
