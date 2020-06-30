package com.kalimagezi.billionareskb.event;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int uid;
	private int cid;
	private String ename;
	private String description;
	@Column(name="image_link")
	private String imageLink;
	@Column(name="event_date")
	private LocalDate eventDate;
	private int going;
	@Column(name="not_going")
	private int notGoing;
	private boolean enabled=true;
	
	
	
	
	
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Event(int id, int uid, int cid, String ename, String description, String imageLink, LocalDate eventDate,
			int going, int notGoing, boolean enabled) {
		super();
		this.id = id;
		this.uid = uid;
		this.cid = cid;
		this.ename = ename;
		this.description = description;
		this.imageLink = imageLink;
		this.eventDate = eventDate;
		this.going = going;
		this.notGoing = notGoing;
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", uid=" + uid + ", cid=" + cid + ", ename=" + ename + ", description=" + description
				+ ", imageLink=" + imageLink + ", eventDate=" + eventDate + ", going=" + going + ", notGoing="
				+ notGoing + ", enabled=" + enabled + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
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
	public void setEventDate(LocalDate date2) {
		this.eventDate = date2;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	
	

}
