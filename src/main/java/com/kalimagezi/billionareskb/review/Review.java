package com.kalimagezi.billionareskb.review;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int aid;
	private int uid;
	private String description;
	@Column(name="create_date")
	private Date createDate = new Date();
	private boolean enabled=true;
	
	
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Review(int id, int aid, int uid, String description, Date createDate, boolean enabled) {
		super();
		this.id = id;
		this.aid = aid;
		this.uid = uid;
		this.description = description;
		this.createDate = createDate;
		this.enabled = enabled;
	}


	@Override
	public String toString() {
		return "Review [id=" + id + ", aid=" + aid + ", uid=" + uid + ", description=" + description + ", createDate="
				+ createDate + ", enabled=" + enabled + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getAid() {
		return aid;
	}


	public void setAid(int aid) {
		this.aid = aid;
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
	
	

}
