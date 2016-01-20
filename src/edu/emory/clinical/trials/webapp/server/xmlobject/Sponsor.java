package edu.emory.clinical.trials.webapp.server.xmlobject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Sponsor {
	
	@XmlElement(name="agency")
	private String agency;

	public String getAgency() {
		return agency;
	}
}
