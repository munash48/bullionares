package com.kalimagezi.billionareskb.analysis;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Analysis {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int eid;
	private int uid;
	private String description;
	@Column(name="create_date")
	private Date createDate = new Date();
	private boolean enabled=true;
	
	public Analysis() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Analysis(int id, int eid, int uid, String description, Date createDate, boolean enabled) {
		super();
		this.id = id;
		this.eid = eid;
		this.uid = uid;
		this.description = description;
		this.createDate = createDate;
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Analysis [id=" + id + ", eid=" + eid + ", uid=" + uid + ", description=" + description + ", createDate="
				+ createDate + ", enabled=" + enabled + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
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
