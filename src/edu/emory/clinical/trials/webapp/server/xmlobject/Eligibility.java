package edu.emory.clinical.trials.webapp.server.xmlobject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Eligibility {

	@XmlElement(name="criteria")
	private TextBlock criteria;
	
	@XmlElement(name="gender")
	private String gender;
	
	@XmlElement(name="minimum_age")
	private String minimumAge;
	
	@XmlElement(name="maximum_age")
	private String maximumAge;
	
	@XmlElement(name="healthy_volunteers")
	private String healthyVolunteers;

	public TextBlock getCriteria() {
		return criteria != null ? criteria : new TextBlock();
	}

	public String getGender() {
		return gender;
	}

	public String getMinimumAge() {
		return minimumAge;
	}

	public String getMaximumAge() {
		return maximumAge;
	}

	public String getHealthyVolunteers() {
		return healthyVolunteers;
	}

	public void setCriteria(TextBlock criteria) {
		this.criteria = criteria;
	}
}
