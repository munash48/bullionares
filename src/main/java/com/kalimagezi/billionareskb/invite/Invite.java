package com.kalimagezi.billionareskb.invite;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Invite {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int uid;
	private String email;
	private String message;
	@Column(name="create_date")
	private Date createdate = new Date();
	private boolean enabled=true;
	
	
	public Invite() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	public Invite(int id, int uid, String email, String message, Date createdate, boolean enabled) {
		super();
		this.id = id;
		this.uid = uid;
		this.email = email;
		this.message = message;
		this.createdate = createdate;
		this.enabled = enabled;
	}





	@Override
	public String toString() {
		return "Invite [id=" + id + ", uid=" + uid + ", email=" + email + ", message=" + message + ", createdate="
				+ createdate + ", enabled=" + enabled + "]";
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Date getCreatedate() {
		return createdate;
	}


	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
