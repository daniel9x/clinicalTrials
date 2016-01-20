package edu.emory.clinical.trials.webapp.server.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "erms_study")
public class ErmsStudy implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ErmsStudyPrimaryKey primaryKey = new ErmsStudyPrimaryKey();
	
	@Column(name="pi_name")
	private String piName;
	
	@Column(name="pi_phone")
	private String piPhone;
	
	@Column(name="pi_email")
	private String piEmail;
	
	@Column(name="dept_div")
	private String deptDiv;
	
	@Column(name="sponsor")
	private String sponsor;
	
	@Column(name="studyPhase")
	private String studyPhase;
	
	@Column(name="studyStatus")
	private String studyStatus;
	
	@Column(name="title")
	private String title;
	
	@Column(name="full_title")
	private String fullTitle;
	
	@Column(name="transfer_date")
	private Date transferDate;
}
