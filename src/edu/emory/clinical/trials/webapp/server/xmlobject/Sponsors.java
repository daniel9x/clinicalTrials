package edu.emory.clinical.trials.webapp.server.xmlobject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Sponsors {

	@XmlElement(name="lead_sponsor")
	private Sponsor leadSponsor;
	
	@XmlElement(name="collaborator")
	private Sponsor collaborator;

	public Sponsor getLeadSponsor() {
		return leadSponsor;
	}

	public Sponsor getCollaborator() {
		return collaborator != null ? collaborator : new Sponsor();
	}
	
}
