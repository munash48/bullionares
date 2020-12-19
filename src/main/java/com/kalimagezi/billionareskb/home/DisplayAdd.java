package com.kalimagezi.billionareskb.home;

import java.util.List;

public class DisplayAdd {
	private int id;
	private int uid;
	private int itemAmount;
	private String title;
	private String description;
	private String imageLink;
	private int noDays;
	private int noClicks;
	private int noReviews;
	private int noPositives;
	private int noNegatives;
	private String website;
	private String isNew;

	private List<DisplayReview> dreviews;

	public DisplayAdd() {
		super();
		// TODO Auto-generated constructor stub
	}



	public DisplayAdd(int id, int uid, int itemAmount, String title, String description, String imageLink, int noDays,
			int noClicks, int noReviews, int noPositives, int noNegatives, String website, String isNew,
			List<DisplayReview> dreviews) {
		super();
		this.id = id;
		this.uid = uid;
		this.itemAmount = itemAmount;
		this.title = title;
		this.description = description;
		this.imageLink = imageLink;
		this.noDays = noDays;
		this.noClicks = noClicks;
		this.noReviews = noReviews;
		this.noPositives = noPositives;
		this.noNegatives = noNegatives;
		this.website = website;
		this.isNew = isNew;
		this.dreviews = dreviews;
	}



	@Override
	public String toString() {
		return "DisplayAdd [id=" + id + ", uid=" + uid + ", itemAmount=" + itemAmount + ", title=" + title
				+ ", description=" + description + ", imageLink=" + imageLink + ", noDays=" + noDays + ", noClicks="
				+ noClicks + ", noReviews=" + noReviews + ", noPositives=" + noPositives + ", noNegatives="
				+ noNegatives + ", website=" + website + ", isNew=" + isNew + ", dreviews=" + dreviews + "]";
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

	public int getItemAmount() {
		return itemAmount;
	}

	public void setItemAmount(int itemAmount) {
		this.itemAmount = itemAmount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public int getNoDays() {
		return noDays;
	}

	public void setNoDays(int noDays) {
		this.noDays = noDays;
	}

	public int getNoClicks() {
		return noClicks;
	}

	public void setNoClicks(int noClicks) {
		this.noClicks = noClicks;
	}

	public int getNoReviews() {
		return noReviews;
	}

	public void setNoReviews(int noReviews) {
		this.noReviews = noReviews;
	}

	public int getNoPositives() {
		return noPositives;
	}

	public void setNoPositives(int noPositives) {
		this.noPositives = noPositives;
	}

	public int getNoNegatives() {
		return noNegatives;
	}

	public void setNoNegatives(int noNegatives) {
		this.noNegatives = noNegatives;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getIsNew() {
		return isNew;
	}

	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}

	public List<DisplayReview> getDreviews() {
		return dreviews;
	}

	public void setDreviews(List<DisplayReview> dreviews) {
		this.dreviews = dreviews;
	}

	

}
