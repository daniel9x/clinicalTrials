package edu.emory.clinical.trials.webapp.server.xmlobject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ResponsibleParty {
	
	@XmlElement(name="responsible_party_type")
	private String responsiblePartyType;
	
	@XmlElement(name="investigator_affiliation")
	private String investigatorAffiliation;
	
	@XmlElement(name="investigator_full_name")
	private String investigatorFullName;
	
	@XmlElement(name="investigator_title")
	private String investigatorTitle;

	public String getResponsiblePartyType() {
		return responsiblePartyType != null ? responsiblePartyType : "";
	}

	public String getInvestigatorAffiliation() {
		return investigatorAffiliation != null ? investigatorAffiliation : "";
	}

	public String getInvestigatorFullName() {
		return investigatorFullName;
	}

	public String getInvestigatorTitle() {
		return investigatorTitle;
	}

	public void setResponsiblePartyType(String responsiblePartyType) {
		this.responsiblePartyType = responsiblePartyType;
		
	}

	public void setInvestigatorAffiliation(String investigatorAffiliation) {
		this.investigatorAffiliation = investigatorAffiliation;
	}
	
}
