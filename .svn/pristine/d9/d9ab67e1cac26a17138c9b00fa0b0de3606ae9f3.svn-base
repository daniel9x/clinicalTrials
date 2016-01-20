package edu.emory.clinical.trials.webapp.server.xmlobject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Location {
	
	@XmlElement(name="facility")
	private Facility facility;
	
	@XmlElement(name="status")
	private String status;
	
	@XmlElement(name="contact")
	private Contact contact;
	
	@XmlElement(name="contact_backup")
	private Contact contactBackup;
	
	@XmlElement(name="investigator")
	private Investigator investigator;

	public Facility getFacility() {
		return facility != null ? facility : new Facility();
	}

	public String getStatus() {
		return status;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}
	
}
