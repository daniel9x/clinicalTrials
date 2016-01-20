package edu.emory.clinical.trials.webapp.server.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class ConditionViewPrimaryKey implements Serializable {

	@Column(name = "category_id")
	private Integer categoryId;

	@Column(name = "condition")
	private String condition;

	public Integer getCategoryId() {
		return categoryId;
	}

	public String getCondition() {
		return condition;
	}
}

