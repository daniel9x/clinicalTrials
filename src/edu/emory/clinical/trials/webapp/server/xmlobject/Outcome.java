package edu.emory.clinical.trials.webapp.server.xmlobject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class Outcome {

	@XmlElement(name="measure")
	private String measure;

	@XmlElement(name="time_frame")
	private String timeFrame;

	@XmlElement(name="safety_issue")
	private String safetyIssue;

	@XmlElement(name="description")
	private String description;

	public String getMeasure() {
		return measure;
	}

	public String getTimeFrame() {
		return timeFrame;
	}

	public String getSafetyIssue() {
		return safetyIssue;
	}

	public String getDescription() {
		return description;
	}


}
