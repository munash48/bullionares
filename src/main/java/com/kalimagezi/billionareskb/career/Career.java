package com.kalimagezi.billionareskb.career;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Career {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int uid;
	private String jobTitle;
	private String specialization;
	private String website;
	private String description;
	@Column(name="from_date")
	private LocalDate startDate;
	private Boolean enabled=true;
	
	public Career() {

		// TODO Auto-generated constructor stub
	}
	





	public Career(int id, int uid, String jobTitle, String specialization, String website, String description,
			LocalDate startDate, Boolean enabled) {
		super();
		this.id = id;
		this.uid = uid;
		this.jobTitle = jobTitle;
		this.specialization = specialization;
		this.website = website;
		this.description = description;
		this.startDate = startDate;
		this.enabled = enabled;
	}






	@Override
	public String toString() {
		return "Career [id=" + id + ", uid=" + uid + ", jobTitle=" + jobTitle + ", specialization=" + specialization
				+ ", website=" + website + ", description=" + description + ", startDate=" + startDate + ", enabled="
				+ enabled + "]";
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	

	public int getUid() {
		return uid;
	}



	public void setUid(int uid) {
		this.uid = uid;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public LocalDate getStartDate() {
		return startDate;
	}



	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}



	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}



	public String getSpecialization() {
		return specialization;
	}



	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}


	public String getWebsite() {
		return website;
	}


	public void setWebsite(String website) {
		this.website = website;
	}



	
	
	
	

}
