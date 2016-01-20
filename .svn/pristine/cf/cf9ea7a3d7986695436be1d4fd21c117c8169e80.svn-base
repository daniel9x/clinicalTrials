package edu.emory.clinical.trials.webapp.server.xmlobject;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class Browse {
	
	@XmlElement(name="mesh_term")
	private List<String> meshTerms;

	public List<String> getMeshTerms() {
		return meshTerms != null ? meshTerms : new ArrayList<String>();
	}
}
