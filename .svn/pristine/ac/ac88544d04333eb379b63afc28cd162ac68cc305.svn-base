package edu.emory.clinical.trials.webapp.server.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class ClinicalTrialMeshTermStagingPrimaryKey implements Serializable {

	@Column(name = "nct_id")
	private String nctId;

	@Column(name = "term")
	private String meshTerm;

	public void setNctId(String nctId) {
		this.nctId = nctId;
	}

	public void setMeshTerm(String meshTerm) {
		this.meshTerm = meshTerm;
	}
}

