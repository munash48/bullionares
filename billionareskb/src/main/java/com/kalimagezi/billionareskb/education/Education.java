package com.kalimagezi.billionareskb.education;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Education {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String level;
	private String award;
	private String institution;
	private String website;
	private int uid;
	@Column(name="completion_date")
	private LocalDate completionDate;
	private boolean enabled=true;
	

	public Education() {
		// TODO Auto-generated constructor stub
	}


	public Education(int id, String level, String award, String institution, String website, int uid,
			LocalDate completionDate, boolean enabled) {
		super();
		this.id = id;
		this.level = level;
		this.award = award;
		this.institution = institution;
		this.website = website;
		this.uid = uid;
		this.completionDate = completionDate;
		this.enabled = enabled;
	}


	@Override
	public String toString() {
		return "Education [id=" + id + ", level=" + level + ", award=" + award + ", institution=" + institution
				+ ", website=" + website + ", uid=" + uid + ", completionDate=" + completionDate + ", enabled="
				+ enabled + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}


	public String getAward() {
		return award;
	}


	public void setAward(String award) {
		this.award = award;
	}


	public String getInstitution() {
		return institution;
	}


	public void setInstitution(String institution) {
		this.institution = institution;
	}


	public String getWebsite() {
		return website;
	}


	public void setWebsite(String website) {
		this.website = website;
	}


	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public LocalDate getCompletionDate() {
		return completionDate;
	}


	public void setCompletionDate(LocalDate completionDate) {
		this.completionDate = completionDate;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	


	
	

}
