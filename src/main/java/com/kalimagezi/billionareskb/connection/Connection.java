package com.kalimagezi.billionareskb.connection;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Connection {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int uid;
	private int cuid;
	private int catid;
	private boolean status;
	@Column(name="conn_date")
	private Date connDate;
	
	
	public Connection() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	


	public Connection(int id, int uid, int cuid, int catid, boolean status, Date connDate) {
		super();
		this.id = id;
		this.uid = uid;
		this.cuid = cuid;
		this.catid = catid;
		this.status = status;
		this.connDate = connDate;
	}





	@Override
	public String toString() {
		return "Connection [id=" + id + ", uid=" + uid + ", cuid=" + cuid + ", catid=" + catid + ", status=" + status
				+ ", connDate=" + connDate + "]";
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


	public int getCuid() {
		return cuid;
	}


	public void setCuid(int cuid) {
		this.cuid = cuid;
	}


	public int getCatid() {
		return catid;
	}


	public void setCatid(int catid) {
		this.catid = catid;
	}
	

	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getConnDate() {
		return connDate;
	}


	public void setConnDate(Date connDate) {
		this.connDate = connDate;
	}
	
}
