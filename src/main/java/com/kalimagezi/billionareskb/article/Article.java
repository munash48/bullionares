package com.kalimagezi.billionareskb.article;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int uid;
	@Column(length = 1255)
	private String description;
	private int catId;
	@Column(name = "image_link")
	private String imageLink;
	private String videoLink;
	@Column(name = "creat_date")
	private Date createDate = new Date();
	@Column(name = "no_opinions")
	private int noOpinions;
	@Column(name = "no_votes")
	private int noVotes;
	@Column(name = "no_reports")
	private int noReports;

	private boolean enabled = true;

	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Article(int id, int uid, String description, int catId, String imageLink, String videoLink, Date createDate,
			int noOpinions, int noVotes, int noReports, boolean enabled) {
		super();
		this.id = id;
		this.uid = uid;
		this.description = description;
		this.catId = catId;
		this.imageLink = imageLink;
		this.videoLink = videoLink;
		this.createDate = createDate;
		this.noOpinions = noOpinions;
		this.noVotes = noVotes;
		this.noReports = noReports;
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", uid=" + uid + ", description=" + description + ", catId=" + catId
				+ ", imageLink=" + imageLink + ", videoLink=" + videoLink + ", createDate=" + createDate
				+ ", noOpinions=" + noOpinions + ", noVotes=" + noVotes + ", noReports=" + noReports + ", enabled="
				+ enabled + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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

	public String getVideoLink() {
		return videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	public int getNoReports() {
		return noReports;
	}

	public void setNoReports(int noReports) {
		this.noReports = noReports;
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

}
