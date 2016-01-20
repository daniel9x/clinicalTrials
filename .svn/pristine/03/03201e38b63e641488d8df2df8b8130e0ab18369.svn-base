package edu.emory.clinical.trials.webapp.server.xmlobject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Contact {

	@XmlElement(name="first_name")
	private String firstName;
	
	@XmlElement(name="last_name")
	private String lastName;
	
	@XmlElement(name="phone")
	private String phone;
	
	@XmlElement(name="email")
	private String email;

	public String getPhone() {
		return phone;
	}
	
	public String getEmail() {
		return email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFullName() {
		if (firstName != null && !firstName.isEmpty()) {
			return firstName + " " + lastName;
		}
		else if (lastName != null) {
			return lastName;
		}
		else {
			return "";
		}
	}
}
