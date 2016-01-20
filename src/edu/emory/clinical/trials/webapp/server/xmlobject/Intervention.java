package edu.emory.clinical.trials.webapp.server.xmlobject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Intervention {
	
	@XmlElement(name="intervention_type")
	private String interventionType;
	
	@XmlElement(name="intervention_name")
	private String interventionName;
	
	@XmlElement(name="description")
	private String description;
	
	@XmlElement(name="arm_group_label")
	private String armGroupLabel;
	
	@XmlElement(name="other_name")
	private String otherName;

	public String getInterventionType() {
		return interventionType;
	}

	public String getInterventionName() {
		return interventionName;
	}

	public String getDescription() {
		return description;
	}

	public String getArmGroupLabel() {
		return armGroupLabel;
	}

	public String getOtherName() {
		return otherName;
	}
}
