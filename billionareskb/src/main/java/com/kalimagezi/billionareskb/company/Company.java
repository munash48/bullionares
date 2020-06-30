package com.kalimagezi.billionareskb.company;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String type;
	private String address;
	private String website;
	@Column(name="creation_date")
	private LocalDate creationDate;
	@Column(name="job_capacity")
	private int jobCapacity;
	private String description;
	@Column(name="working_hours")
	private String workingHours;
	private int uid;
	private Boolean enabled=true;
	
	public Company() {
		// TODO Auto-generated constructor stub
	}


	

	public Company(int id, String name, String type, String address, String website, LocalDate creationDate,
			int jobCapacity, String description, String workingHours, int uid, Boolean enabled) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.address = address;
		this.website = website;
		this.creationDate = creationDate;
		this.jobCapacity = jobCapacity;
		this.description = description;
		this.workingHours = workingHours;
		this.uid = uid;
		this.enabled = enabled;
	}




	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", type=" + type + ", address=" + address + ", website="
				+ website + ", creationDate=" + creationDate + ", jobCapacity=" + jobCapacity + ", description="
				+ description + ", workingHours=" + workingHours + ", uid=" + uid + ", enabled=" + enabled + "]";
	}
	
	
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
		
	public int getJobCapacity() {
		return jobCapacity;
	}
	public void setJobCapacity(int jobCapacity) {
		this.jobCapacity = jobCapacity;
	}

	public String getWorkingHours() {
		return workingHours;
	}
	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	

}
