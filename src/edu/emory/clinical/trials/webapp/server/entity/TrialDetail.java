package edu.emory.clinical.trials.webapp.server.entity;

import java.util.ArrayList;
import java.util.List;

public class TrialDetail {

	private String nctId;
	private Integer studyId;
	private String briefTitle;
	private String condition;
	private String piName;
	private String piEmail;
	private String studyStatus;
	private String briefSummary;
	private String deptDiv;
	private String deptDivId;
	private String primaryCategory;
	private String secondaryCategory;
	private String startDate;
	private String endDate;
	private String firstReceivedDate;
	private String lastChangedDate;
	private String contactName;
	private String contactPhone;
	private String contactEmail;
	private String contactBackupName;
	private String contactBackupPhone;
	private String contactBackupEmail;
	private String minimumAge;
	private String maximumAge;
	private String genders;
	private String healthyVolunteers;
	private List<ClinicalTrialIntervention> interventions = new ArrayList<ClinicalTrialIntervention>();
	private List<ErmsStudyCRC> clinicalResearchCoordinators = new ArrayList<ErmsStudyCRC>();

	public TrialDetail(SearchResultView searchResultView) {
		this.nctId = searchResultView.getPrimaryKey().getNctId();
		this.studyId = searchResultView.getPrimaryKey().getStudyId();
		this.briefTitle = searchResultView.getBriefTitle();
		this.condition = searchResultView.getCondition();
		this.piName = searchResultView.getPiName();
		this.piEmail = searchResultView.getPiEmail();
		this.studyStatus = searchResultView.getStudyStatus();
		this.briefSummary = searchResultView.getBriefSummary();
		this.deptDiv = searchResultView.getDeptDiv();
		this.deptDivId = searchResultView.getDeptDivId();
		this.primaryCategory = searchResultView.getPrimaryCategory();
		this.secondaryCategory = searchResultView.getSecondaryCategory();
		this.startDate = searchResultView.getStartDate();
		this.endDate = searchResultView.getEndDate();
		this.firstReceivedDate = searchResultView.getFirstReceivedDate();
		this.lastChangedDate = searchResultView.getLastChangedDate();
		this.contactName = searchResultView.getContactName();
		this.contactPhone = searchResultView.getContactPhone();
		this.contactEmail = searchResultView.getContactEmail();
		this.contactBackupName = searchResultView.getContactBackupName();
		this.contactBackupPhone = searchResultView.getContactBackupPhone();
		this.contactBackupEmail = searchResultView.getContactBackupEmail();
		this.minimumAge = searchResultView.getMinimumAge();
		this.maximumAge = searchResultView.getMaximumAge();
		this.genders = searchResultView.getGenders();
		this.healthyVolunteers = searchResultView.getHealthyVolunteers();
	}

	public String getNctId() {
		return nctId;
	}

	public Integer getStudyId() {
		return studyId;
	}

	public String getBriefTitle() {
		return briefTitle;
	}

	public String getCondition() {
		return condition;
	}

	public String getPiName() {
		return piName;
	}

	public String getPiEmail() {
		return piEmail;
	}

	public String getStudyStatus() {
		return studyStatus;
	}

	public String getBriefSummary() {
		return briefSummary;
	}

	public String getDeptDiv() {
		return deptDiv;
	}

	public String getDeptDivId() {
		return deptDivId;
	}

	public String getPrimaryCategory() {
		return primaryCategory;
	}

	public String getSecondaryCategory() {
		return secondaryCategory;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public String getFirstReceivedDate() {
		return firstReceivedDate;
	}

	public String getLastChangedDate() {
		return lastChangedDate;
	}

	public String getContactName() {
		return contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public String getContactBackupName() {
		return contactBackupName;
	}

	public String getContactBackupPhone() {
		return contactBackupPhone;
	}

	public String getContactBackupEmail() {
		return contactBackupEmail;
	}

	public String getMinimumAge() {
		return minimumAge;
	}

	public String getMaximumAge() {
		return maximumAge;
	}

	public String getGenders() {
		return genders;
	}

	public String getHealthyVolunteers() {
		return healthyVolunteers;
	}

	public List<ClinicalTrialIntervention> getInterventions() {
		return interventions;
	}

	public List<ErmsStudyCRC> getClinicalResearchCoordinators() {
		return clinicalResearchCoordinators;
	}

	public void setInterventions(List<ClinicalTrialIntervention> interventions) {
		this.interventions = interventions;
	}

	public void setClinicalResearchCoordinators(List<ErmsStudyCRC> clinicalResearchCoordinators) {
		this.clinicalResearchCoordinators = clinicalResearchCoordinators;
	}

}
