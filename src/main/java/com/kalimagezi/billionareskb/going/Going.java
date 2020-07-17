package com.kalimagezi.billionareskb.going;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Going {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int eid;
	private int uid;
	private Date voteDate = new Date();
	public Going() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Going(int id, int eid, int uid, Date voteDate) {
		super();
		this.id = id;
		this.eid = eid;
		this.uid = uid;
		this.voteDate = voteDate;
	}
	@Override
	public String toString() {
		return "Going [id=" + id + ", eid=" + eid + ", uid=" + uid + ", voteDate=" + voteDate + "]";
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
	public Date getVoteDate() {
		return voteDate;
	}
	public void setVoteDate(Date voteDate) {
		this.voteDate = voteDate;
	}
	
	

}
