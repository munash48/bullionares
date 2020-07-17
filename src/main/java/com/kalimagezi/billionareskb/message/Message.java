package com.kalimagezi.billionareskb.message;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	private int uid;
	private int wuid;
	private int chatid;
	private String message;
	private Date mdate = new Date();
	private boolean enabled = false;

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(int cid, int uid, int wuid, int chatid, String message, Date mdate, boolean enabled) {
		super();
		this.cid = cid;
		this.uid = uid;
		this.wuid = wuid;
		this.chatid = chatid;
		this.message = message;
		this.mdate = mdate;
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Message [cid=" + cid + ", uid=" + uid + ", wuid=" + wuid + ", chatid=" + chatid + ", message=" + message
				+ ", mdate=" + mdate + ", enabled=" + enabled + "]";
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getWuid() {
		return wuid;
	}

	public void setWuid(int wuid) {
		this.wuid = wuid;
	}

	public int getChatid() {
		return chatid;
	}

	public void setChatid(int chatid) {
		this.chatid = chatid;
	}

	public Date getMdate() {
		return mdate;
	}

	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
