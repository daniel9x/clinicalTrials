package edu.emory.clinical.trials.webapp.server.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ct_intervention_staging")
public class ClinicalTrialInterventionStaging {
	
	@Id
	@Column(name="intervention_id")
	private Integer interventionId;
	
	@Column(name="intervention_name")
	private String interventionName;
	
	@Column(name="nct_id")
	private String nctId;
	
	@Column(name="intervention_type")
	private String interventionType;
	
	@Column(name="description")
	private String description;
	
	@Column(name="arm_group_label")
	private String armGroupLabel;
	
	@Column(name="other_name")
	private String otherName;
	
	@Column(name="transfer_date")
	private Date transferDate;

	public void setInterventionId(Integer interventionId) {
		this.interventionId = interventionId;
	}

	public void setInterventionName(String interventionName) {
		this.interventionName = interventionName;
	}

	public void setNctId(String nctId) {
		this.nctId = nctId;
	}

	public void setInterventionType(String interventionType) {
		this.interventionType = interventionType;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setArmGroupLabel(String armGroupLabel) {
		this.armGroupLabel = armGroupLabel;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}

	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}
	
}