package edu.emory.clinical.trials.webapp.server.xmlobject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Investigator {
	
	@XmlElement(name="first_name")
	private String firstName;
	
	@XmlElement(name="middle_name")
	private String middleName;
	
	@XmlElement(name="last_name")
	private String lastName;
	
	@XmlElement(name="degrees")
	private String degrees;
	
	@XmlElement(name="role")
	private String role;
	
	@XmlElement(name="affiliation")
	private String affiliation;

	public String getFirstName() {
		return firstName != null ? firstName : "";
	}
	
	public String getLastName() {
		return lastName != null ? lastName : "";
	}

	public String getRole() {
		return role != null ? role : "";
	}

	public String getAffiliation() {
		return affiliation != null ? affiliation : "";
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
