package com.kalimagezi.billionareskb.negative;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Negative {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int aid;
	private int uid;
	private Date voteDate = new Date();
	
	public Negative() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Negative(int id, int aid, int uid, Date voteDate) {
		super();
		this.id = id;
		this.aid = aid;
		this.uid = uid;
		this.voteDate = voteDate;
	}
	@Override
	public String toString() {
		return "Negative [id=" + id + ", aid=" + aid + ", uid=" + uid + ", voteDate=" + voteDate + "]";
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
	public Date getVoteDate() {
		return voteDate;
	}
	public void setVoteDate(Date voteDate) {
		this.voteDate = voteDate;
	}
	
	

}
