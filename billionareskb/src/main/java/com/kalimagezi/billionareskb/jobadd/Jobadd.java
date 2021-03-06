package com.kalimagezi.billionareskb.jobadd;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Jobadd {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int cid;
	private int uid;
	@Column(name="comp_id")	
	private int compId;
	@Column(name="job_title")
	private String jobTitle;
	@Column(name="job_category")
	private String jobCategory;
	private String salary;
	private String description;
	@Column(name="image_link")
	private String imageLink;
	@Column(name="no_positions")
	private int noPositions;
	@Column(name="add_date")
	private Date addDate= new Date();
	@Column(name="dead_line")
	private LocalDate deadline;
	private int recomended;
	@Column(name="not_recomended")
	private int notRecomended;
	private boolean enabled=true;
	
	
	
	
	
	public Jobadd() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Jobadd(int id, int cid, int uid, int compId, String jobTitle, String jobCategory, String salary,
			String description, String imageLink, int noPositions, Date addDate, LocalDate deadline, int recomended,
			int notRecomended, boolean enabled) {
		super();
		this.id = id;
		this.cid = cid;
		this.uid = uid;
		this.compId = compId;
		this.jobTitle = jobTitle;
		this.jobCategory = jobCategory;
		this.salary = salary;
		this.description = description;
		this.imageLink = imageLink;
		this.noPositions = noPositions;
		this.addDate = addDate;
		this.deadline = deadline;
		this.recomended = recomended;
		this.notRecomended = notRecomended;
		this.enabled = enabled;
	}



	@Override
	public String toString() {
		return "Jobadd [id=" + id + ", cid=" + cid + ", uid=" + uid + ", compId=" + compId + ", jobTitle=" + jobTitle
				+ ", jobCategory=" + jobCategory + ", salary=" + salary + ", description=" + description
				+ ", imageLink=" + imageLink + ", noPositions=" + noPositions + ", addDate=" + addDate + ", deadline="
				+ deadline + ", recomended=" + recomended + ", notRecomended=" + notRecomended + ", enabled=" + enabled
				+ "]";
	}
	public int getRecomended() {
		return recomended;
	}



	public void setRecomended(int recomended) {
		this.recomended = recomended;
	}



	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public String getSalary() {
		return salary;
	}



	public void setSalary(String salary) {
		this.salary = salary;
	}



	public int getNotRecomended() {
		return notRecomended;
	}



	public int getNoPositions() {
		return noPositions;
	}



	public void setNoPositions(int noPositions) {
		this.noPositions = noPositions;
	}



	public void setNotRecomended(int notRecomended) {
		this.notRecomended = notRecomended;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCompId() {
		return compId;
	}
	public void setCompId(int compId) {
		this.compId = compId;
	}
	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobCategory() {
		return jobCategory;
	}
	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public LocalDate getDeadline() {
		return deadline;
	}
	public void setDeadline(LocalDate date2) {
		this.deadline = date2;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	
}
