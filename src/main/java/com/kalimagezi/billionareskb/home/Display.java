package com.kalimagezi.billionareskb.home;

import java.util.Date;
import java.util.List;

public class Display {

	private String fullName;
	private String userImageLink;
	private String artImageLink;
	private String artVideoLink;
	private String artDescription;
	private Date artCreateDate;
	private int noOpinions;
	private int noVotes;
	private int noReports;
	private int uid;
	private int catid;
	private int artid;
	private List<DisplayOpinion> opinions;

	public Display() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Display(String fullName, String userImageLink, String artImageLink, String artVideoLink,
			String artDescription, Date artCreateDate, int noOpinions, int noVotes, int noReports, int uid, int catid,
			int artid, List<DisplayOpinion> opinions) {
		super();
		this.fullName = fullName;
		this.userImageLink = userImageLink;
		this.artImageLink = artImageLink;
		this.artVideoLink = artVideoLink;
		this.artDescription = artDescription;
		this.artCreateDate = artCreateDate;
		this.noOpinions = noOpinions;
		this.noVotes = noVotes;
		this.noReports = noReports;
		this.uid = uid;
		this.catid = catid;
		this.artid = artid;
		this.opinions = opinions;
	}

	@Override
	public String toString() {
		return "Display [fullName=" + fullName + ", userImageLink=" + userImageLink + ", artImageLink=" + artImageLink
				+ ", artVideoLink=" + artVideoLink + ", artDescription=" + artDescription + ", artCreateDate="
				+ artCreateDate + ", noOpinions=" + noOpinions + ", noVotes=" + noVotes + ", noReports=" + noReports
				+ ", uid=" + uid + ", catid=" + catid + ", artid=" + artid + ", opinions=" + opinions + "]";
	}

	public int getCatid() {
		return catid;
	}

	public void setCatid(int catid) {
		this.catid = catid;
	}

	public int getArtid() {
		return artid;
	}

	public void setArtid(int artid) {
		this.artid = artid;
	}

	public List<DisplayOpinion> getOpinions() {
		return opinions;
	}

	public String getArtVideoLink() {
		return artVideoLink;
	}

	public void setArtVideoLink(String artVideoLink) {
		this.artVideoLink = artVideoLink;
	}

	public void setOpinions(List<DisplayOpinion> dopinions) {
		this.opinions = dopinions;
	}

	public String getArtDescription() {
		return artDescription;
	}

	public void setArtDescription(String artDescription) {
		this.artDescription = artDescription;
	}

	public Date getArtCreateDate() {
		return artCreateDate;
	}

	public void setArtCreateDate(Date artCreateDate) {
		this.artCreateDate = artCreateDate;
	}

	public int getNoOpinions() {
		return noOpinions;
	}

	public void setNoOpinions(int noOpinions) {
		this.noOpinions = noOpinions;
	}

	public int getNoVotes() {
		return noVotes;
	}

	public void setNoVotes(int noVotes) {
		this.noVotes = noVotes;
	}

	public int getNoReports() {
		return noReports;
	}

	public void setNoReports(int noReports) {
		this.noReports = noReports;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserImageLink() {
		return userImageLink;
	}

	public void setUserImageLink(String userImageLink) {
		this.userImageLink = userImageLink;
	}

	public String getArtImageLink() {
		return artImageLink;
	}

	public void setArtImageLink(String artImageLink) {
		this.artImageLink = artImageLink;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

}
