package com.kalimagezi.billionareskb.report;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Report {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int uid;
	private int aid;
	private Date createDate = new Date();
	private String status;
	private boolean enabled=true;
	
	
	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Report(int id, int uid, int aid, String description, Date createDate, String status, boolean enabled) {
		super();
		this.id = id;
		this.uid = uid;
		this.aid = aid;
		this.createDate = createDate;
		this.status = status;
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Report [id=" + id + ", uid=" + uid + ", aid=" + aid +  ", createDate="
				+ createDate + ", status=" + status + ", enabled=" + enabled + "]";
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


	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}



	public Date getCreateDate() {
		return createDate;
	}



	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
	


}
