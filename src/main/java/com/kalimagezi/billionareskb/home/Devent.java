package com.kalimagezi.billionareskb.home;

import java.time.LocalDate;

public class Devent {
	
	private int id;
	private int uid;
	private String ename;
	private String byname;
	private String description;
	private String imageLink;
	private LocalDate eventDate;
	private int going;
	private int notGoing;
	public Devent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Devent(int id, int uid, String ename, String byname, String description, String imageLink,
			LocalDate eventDate, int going, int notGoing) {
		super();
		this.id = id;
		this.uid = uid;
		this.ename = ename;
		this.byname = byname;
		this.description = description;
		this.imageLink = imageLink;
		this.eventDate = eventDate;
		this.going = going;
		this.notGoing = notGoing;
	}
	@Override
	public String toString() {
		return "Devent [id=" + id + ", uid=" + uid + ", ename=" + ename + ", byname=" + byname + ", description="
				+ description + ", imageLink=" + imageLink + ", eventDate=" + eventDate + ", going=" + going
				+ ", notGoing=" + notGoing + "]";
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
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getByname() {
		return byname;
	}
	public void setByname(String byname) {
		this.byname = byname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	public LocalDate getEventDate() {
		return eventDate;
	}
	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}
	public int getGoing() {
		return going;
	}
	public void setGoing(int going) {
		this.going = going;
	}
	public int getNotGoing() {
		return notGoing;
	}
	public void setNotGoing(int notGoing) {
		this.notGoing = notGoing;
	}
	
	

}
