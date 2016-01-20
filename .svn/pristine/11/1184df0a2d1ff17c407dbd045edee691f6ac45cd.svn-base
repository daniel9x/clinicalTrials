package edu.emory.clinical.trials.webapp.server.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ct_intervention")
public class ClinicalTrialIntervention {
	
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
	
	public Integer getInterventionId() {
		return interventionId;
	}

	public String getInterventionName() {
		return interventionName;
	}

	public String getNctId() {
		return nctId;
	}

	public String getInterventionType() {
		return interventionType;
	}

	public String getDescription() {
		return description;
	}

	public String getArmGroupLabel() {
		return armGroupLabel;
	}

	public String getOtherName() {
		return otherName;
	}

	public Date getTransferDate() {
		return transferDate;
	}
	
}