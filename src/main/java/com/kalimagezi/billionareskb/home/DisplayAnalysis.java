package com.kalimagezi.billionareskb.home;

import java.util.Date;

public class DisplayAnalysis {
	private String fullName;
	private String aImageLink;
	private Date aCreateDate;
	private String aDescription;
	private int aUid;
	
	public DisplayAnalysis() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DisplayAnalysis(String fullName, String aImageLink, Date aCreateDate, String aDescription, int aUid) {
		super();
		this.fullName = fullName;
		this.aImageLink = aImageLink;
		this.aCreateDate = aCreateDate;
		this.aDescription = aDescription;
		this.aUid = aUid;
	}

	@Override
	public String toString() {
		return "DisplayAnalysis [fullName=" + fullName + ", aImageLink=" + aImageLink + ", aCreateDate=" + aCreateDate
				+ ", aDescription=" + aDescription + ", rUid=" + aUid + "]";
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getaImageLink() {
		return aImageLink;
	}

	public void setaImageLink(String aImageLink) {
		this.aImageLink = aImageLink;
	}

	public Date getaCreateDate() {
		return aCreateDate;
	}

	public void setaCreateDate(Date aCreateDate) {
		this.aCreateDate = aCreateDate;
	}

	public String getaDescription() {
		return aDescription;
	}

	public void setaDescription(String aDescription) {
		this.aDescription = aDescription;
	}

	public int getaUid() {
		return aUid;
	}

	public void setaUid(int aUid) {
		this.aUid = aUid;
	}

	
	

}
