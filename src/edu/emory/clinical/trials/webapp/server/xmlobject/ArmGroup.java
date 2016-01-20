package edu.emory.clinical.trials.webapp.server.xmlobject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class ArmGroup {

	@XmlElement(name="arm_group_label")
	private String armGroupLabel;
	
	@XmlElement(name="arm_group_type")
	private String armGroupType;
	
	@XmlElement(name="description")
	private String description;

	public String getArmGroupLabel() {
		return armGroupLabel;
	}

	public String getArmGroupType() {
		return armGroupType;
	}

	public String getDescription() {
		return description;
	}

}
