package com.kalimagezi.billionareskb.recomendations;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Recommendations {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int jaid;
	private int uid;
	private String description;
	@Column(name="create_date")
	private Date createDate = new Date();
	private boolean enabled=true;
	
	
	
	public Recommendations() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Recommendations(int id, int jaid, int uid, String description, Date createDate, boolean enabled) {
		super();
		this.id = id;
		this.jaid = jaid;
		this.uid = uid;
		this.description = description;
		this.createDate = createDate;
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Recommendations [id=" + id + ", jaid=" + jaid + ", uid=" + uid + ", description=" + description
				+ ", createDate=" + createDate + ", enabled=" + enabled + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getJaid() {
		return jaid;
	}

	public void setJaid(int jaid) {
		this.jaid = jaid;
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
