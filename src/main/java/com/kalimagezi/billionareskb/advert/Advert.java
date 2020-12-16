package com.kalimagezi.billionareskb.advert;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Advert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int uid;
	private int cid;
	@Column(name = "advert_amount")
	private int advertAmount;
	@Column(name = "item_amount")
	private int itemAmount;
	private String title;
	private String description;
	@Column(name = "image_link")
	private String imageLink;
	@Column(name = "no_days")
	private int noDays;
	@Column(name = "no_clicks")
	private int noClicks;
	@Column(name = "no_reviews")
	private int noReviews;
	@Column(name = "no_positives")
	private int noPositives;
	@Column(name = "no_negatives")
	private int noNegatives;
	private int rating;
	@Column(name = "date_from")
	private LocalDate dateFrom;
	private Date createDate= new Date();
	
	private String website;
	@Column(name = "transaction_id")
	private String transactionId;
	private boolean enabled = false;

	public Advert() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Advert(int id, int uid, int cid, int advertAmount, int itemAmount, String title, String description,
			String imageLink, int noDays, int noClicks, int noReviews, int noPositives, int noNegatives, int rating,
			LocalDate dateFrom, Date createDate, String website, String transactionId, boolean enabled) {
		super();
		this.id = id;
		this.uid = uid;
		this.cid = cid;
		this.advertAmount = advertAmount;
		this.itemAmount = itemAmount;
		this.title = title;
		this.description = description;
		this.imageLink = imageLink;
		this.noDays = noDays;
		this.noClicks = noClicks;
		this.noReviews = noReviews;
		this.noPositives = noPositives;
		this.noNegatives = noNegatives;
		this.rating = rating;
		this.dateFrom = dateFrom;
		this.createDate = createDate;
		this.website = website;
		this.transactionId = transactionId;
		this.enabled = enabled;
	}



	@Override
	public String toString() {
		return "Advert [id=" + id + ", uid=" + uid + ", cid=" + cid + ", advertAmount=" + advertAmount + ", itemAmount="
				+ itemAmount + ", title=" + title + ", description=" + description + ", imageLink=" + imageLink
				+ ", noDays=" + noDays + ", noClicks=" + noClicks + ", noReviews=" + noReviews + ", noPositives="
				+ noPositives + ", noNegatives=" + noNegatives + ", rating=" + rating + ", dateFrom=" + dateFrom
				+ ", createDate=" + createDate + ", website=" + website + ", transactionId=" + transactionId
				+ ", enabled=" + enabled + "]";
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

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getAdvertAmount() {
		return advertAmount;
	}

	public void setAdvertAmount(int advertAmount) {
		this.advertAmount = advertAmount;
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public LocalDate getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(LocalDate dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	

}
