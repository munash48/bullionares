package com.kalimagezi.billionareskb.recomend;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Recomend {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int jaid;
	private int uid;
	private Date voteDate = new Date();
	public Recomend() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Recomend(int id, int jaid, int uid, Date voteDate) {
		super();
		this.id = id;
		this.jaid = jaid;
		this.uid = uid;
		this.voteDate = voteDate;
	}
	@Override
	public String toString() {
		return "Recomend [id=" + id + ", jaid=" + jaid + ", uid=" + uid + ", voteDate=" + voteDate + "]";
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
	public Date getVoteDate() {
		return voteDate;
	}
	public void setVoteDate(Date voteDate) {
		this.voteDate = voteDate;
	}
	
	

}
