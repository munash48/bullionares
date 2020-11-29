package com.kalimagezi.billionareskb.home;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public class DisplayJobAdd {
	private int jaid;
	private int jauid;
	private String compName;
	private String adByName;
	private String compWeb;
	private String jobTitle;
	private String description;
	private String imageLink;
	private String jobCategory;
	private String salary;
	private int noPositions;
	private Date addDate;
	private LocalDate deadline;
	private int noRecom;
	private int noNotRecom;
	private int noRecomendations;

	private List<DisplayWrittenReco> dwRecos;

	public DisplayJobAdd() {
		super();
		// TODO Auto-generated constructor stub
	}






	public DisplayJobAdd(int jaid, int jauid, String compName, String adByName, String compWeb, String jobTitle,
			String description, String imageLink, String jobCategory, String salary, int noPositions, Date addDate,
			LocalDate deadline, int noRecom, int noNotRecom, int noRecomendations, List<DisplayWrittenReco> dwRecos) {
		super();
		this.jaid = jaid;
		this.jauid = jauid;
		this.compName = compName;
		this.adByName = adByName;
		this.compWeb = compWeb;
		this.jobTitle = jobTitle;
		this.description = description;
		this.imageLink = imageLink;
		this.jobCategory = jobCategory;
		this.salary = salary;
		this.noPositions = noPositions;
		this.addDate = addDate;
		this.deadline = deadline;
		this.noRecom = noRecom;
		this.noNotRecom = noNotRecom;
		this.noRecomendations = noRecomendations;
		this.dwRecos = dwRecos;
	}






	@Override
	public String toString() {
		return "DisplayJobAdd [jaid=" + jaid + ", jauid=" + jauid + ", compName=" + compName + ", adByName=" + adByName
				+ ", compWeb=" + compWeb + ", jobTitle=" + jobTitle + ", description=" + description + ", imageLink="
				+ imageLink + ", jobCategory=" + jobCategory + ", salary=" + salary + ", noPositions=" + noPositions
				+ ", addDate=" + addDate + ", deadline=" + deadline + ", noRecom=" + noRecom + ", noNotRecom="
				+ noNotRecom + ", noRecomendations=" + noRecomendations + ", dwRecos=" + dwRecos + "]";
	}


	public int getJaid() {
		return jaid;
	}


	public void setJaid(int jaid) {
		this.jaid = jaid;
	}


	public int getJauid() {
		return jauid;
	}


	public void setJauid(int jauid) {
		this.jauid = jauid;
	}


	public String getCompName() {
		return compName;
	}


	public void setCompName(String compName) {
		this.compName = compName;
	}


	public String getAdByName() {
		return adByName;
	}


	public void setAdByName(String adByName) {
		this.adByName = adByName;
	}


	public String getCompWeb() {
		return compWeb;
	}


	public void setCompWeb(String compWeb) {
		this.compWeb = compWeb;
	}


	public String getJobTitle() {
		return jobTitle;
	}


	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImageLink() {
		return imageLink;
	}


	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}


	public String getJobCategory() {
		return jobCategory;
	}


	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}


	public String getSalary() {
		return salary;
	}


	public void setSalary(String salary) {
		this.salary = salary;
	}


	public int getNoPositions() {
		return noPositions;
	}


	public void setNoPositions(int noPositions) {
		this.noPositions = noPositions;
	}


	public Date getAddDate() {
		return addDate;
	}


	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}


	public int getNoRecom() {
		return noRecom;
	}


	public void setNoRecom(int noRecom) {
		this.noRecom = noRecom;
	}


	public int getNoNotRecom() {
		return noNotRecom;
	}


	public void setNoNotRecom(int noNotRecom) {
		this.noNotRecom = noNotRecom;
	}


	public int getNoRecomendations() {
		return noRecomendations;
	}


	public void setNoRecomendations(int noRecomendations) {
		this.noRecomendations = noRecomendations;
	}


	public List<DisplayWrittenReco> getDwRecos() {
		return dwRecos;
	}


	public void setDwRecos(List<DisplayWrittenReco> dwRecos) {
		this.dwRecos = dwRecos;
	}




	public LocalDate getDeadline() {
		return deadline;
	}




	public void setDeadline(LocalDate localDate) {
		this.deadline = localDate;
	}
	
	

	

}
