package edu.emory.clinical.trials.webapp.server.xmlobject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Facility {

	@XmlElement(name="name")
	private String name;
	
	@XmlElement(name="address")
	private Address address;

	public String getName() {
		return name != null ? name : "";
	}

	public Address getAddress() {
		return address;
	}
}
