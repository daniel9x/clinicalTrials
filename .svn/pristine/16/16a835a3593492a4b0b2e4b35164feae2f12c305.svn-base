package edu.emory.clinical.trials.webapp.server.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ct_keyword_staging")
public class ClinicalTrialKeywordStaging {
	
	@EmbeddedId
	private ClinicalTrialKeywordStagingPrimaryKey primaryKey = new ClinicalTrialKeywordStagingPrimaryKey();
	
	@Column(name="transfer_date")
	private Date transferDate;

	public void setPrimaryKey(ClinicalTrialKeywordStagingPrimaryKey primaryKey) {
		this.primaryKey = primaryKey;
	}

	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}
}