package edu.emory.clinical.trials.webapp.server.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class TrialCategory {
	
	@Id
	@Column(name="category_id")
	private Integer id;
	
	@Column(name="category_term")
	private String categoryTerm;
	
	@OneToMany(mappedBy = "category", fetch=FetchType.EAGER)
	private List<ConditionView> conditions = new ArrayList<ConditionView>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryTerm() {
		return categoryTerm;
	}

	public void setCategoryTerm(String categoryTerm) {
		this.categoryTerm = categoryTerm;
	}

	public List<ConditionView> getConditions() {
		return conditions;
	}

	public void setConditions(List<ConditionView> conditions) {
		this.conditions = conditions;
	}
}
