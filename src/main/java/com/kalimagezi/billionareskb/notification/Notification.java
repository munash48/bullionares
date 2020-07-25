package com.kalimagezi.billionareskb.notification;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Notification {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int uid;
	private int chart;
	private int message;
	private int  events;
	private int jobad;
	private boolean enabled=true;
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Notification(int id, int uid, int chart, int message, int events, int jobad, boolean enabled) {
		super();
		this.id = id;
		this.uid = uid;
		this.chart = chart;
		this.message = message;
		this.events = events;
		this.jobad = jobad;
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "Notification [id=" + id + ", uid=" + uid + ", chart=" + chart + ", message=" + message + ", events="
				+ events + ", jobad=" + jobad + ", enabled=" + enabled + "]";
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
	public int getChart() {
		return chart;
	}
	public void setChart(int chart) {
		this.chart = chart;
	}
	public int getMessage() {
		return message;
	}
	public void setMessage(int message) {
		this.message = message;
	}
	public int getEvents() {
		return events;
	}
	public void setEvents(int events) {
		this.events = events;
	}
	public int getJobad() {
		return jobad;
	}
	public void setJobad(int jobad) {
		this.jobad = jobad;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	

}
