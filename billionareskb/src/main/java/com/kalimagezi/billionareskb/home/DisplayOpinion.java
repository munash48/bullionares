package com.kalimagezi.billionareskb.home;

import java.util.Date;

public class DisplayOpinion {
	
	private String fullName;
	private String opImageLink;
	private Date opCreateDate;
	private String opDescription;
	private int opUid;
	
	
	public DisplayOpinion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public DisplayOpinion(String fullName, String opImageLink, Date opCreateDate, String opDescription, int opUid) {
		super();
		this.fullName = fullName;
		this.opImageLink = opImageLink;
		this.opCreateDate = opCreateDate;
		this.opDescription = opDescription;
		this.opUid = opUid;
	}



	@Override
	public String toString() {
		return "DisplayOpinion [fullName=" + fullName + ", opImageLink=" + opImageLink + ", opCreateDate="
				+ opCreateDate + ", opDescription=" + opDescription + ", opUid=" + opUid + "]";
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getOpImageLink() {
		return opImageLink;
	}
	public void setOpImageLink(String opImageLink) {
		this.opImageLink = opImageLink;
	}
	public Date getOpCreateDate() {
		return opCreateDate;
	}
	public void setOpCreateDate(Date opCreateDate) {
		this.opCreateDate = opCreateDate;
	}
	public String getOpDescription() {
		return opDescription;
	}
	public void setOpDescription(String opDescription) {
		this.opDescription = opDescription;
	}



	public int getOpUid() {
		return opUid;
	}



	public void setOpUid(int opUid) {
		this.opUid = opUid;
	}
	
	
	

}
