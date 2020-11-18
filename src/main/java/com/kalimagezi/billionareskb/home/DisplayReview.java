package com.kalimagezi.billionareskb.home;

import java.util.Date;

public class DisplayReview {
	
	private String fullName;
	private String rImageLink;
	private Date rCreateDate;
	private String rDescription;
	private int rUid;
	
	public DisplayReview() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DisplayReview(String fullName, String rImageLink, Date rCreateDate, String rDescription, int rUid) {
		super();
		this.fullName = fullName;
		this.rImageLink = rImageLink;
		this.rCreateDate = rCreateDate;
		this.rDescription = rDescription;
		this.rUid = rUid;
	}

	@Override
	public String toString() {
		return "DisplayReview [fullName=" + fullName + ", rImageLink=" + rImageLink + ", rCreateDate=" + rCreateDate
				+ ", rDescription=" + rDescription + ", rUid=" + rUid + "]";
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getrImageLink() {
		return rImageLink;
	}

	public void setrImageLink(String rImageLink) {
		this.rImageLink = rImageLink;
	}

	public Date getrCreateDate() {
		return rCreateDate;
	}

	public void setrCreateDate(Date rCreateDate) {
		this.rCreateDate = rCreateDate;
	}

	public String getrDescription() {
		return rDescription;
	}

	public void setrDescription(String rDescription) {
		this.rDescription = rDescription;
	}

	public int getrUid() {
		return rUid;
	}

	public void setrUid(int rUid) {
		this.rUid = rUid;
	}
	
	
	
	
	

}
