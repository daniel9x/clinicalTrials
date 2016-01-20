package edu.emory.clinical.trials.webapp.server.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ct_mesh_term_staging")
public class ClinicalTrialMeshTermStaging {
	
	@EmbeddedId
	private ClinicalTrialMeshTermStagingPrimaryKey primaryKey = new ClinicalTrialMeshTermStagingPrimaryKey();
	
	@Column(name="term_type") 
	private String meshTermType;
	
	@Column(name="transfer_date")
	private Date transferDate;

	public void setPrimaryKey(ClinicalTrialMeshTermStagingPrimaryKey primaryKey) {
		this.primaryKey = primaryKey;
	}

	public void setMeshTermType(String meshTermType) {
		this.meshTermType = meshTermType;
	}

	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}
}
