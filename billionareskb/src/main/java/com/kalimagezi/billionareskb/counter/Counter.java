package com.kalimagezi.billionareskb.counter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Counter {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int cid;
	private int uid;
	@Column(name="no_votes")
	private int noVotes;
	@Column(name="no_opinion")
	private int noOpinions;
	@Column(name="no_articles")
	private int noArticles;
	@Column(name="no_connections")
	private int noConnections;
	@Column(name="no_invites")
	private int noInvites;
	@Column(name="no_reports")
	private int noReports;
	private int total;
	private boolean enabled=true;
	
	
	
	public Counter() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Counter(int id, int cid, int uid, int noVotes, int noOpinions, int noArticles, int noConnections,
			int noInvites, int noReports, int total, boolean enabled) {
		super();
		this.id = id;
		this.cid = cid;
		this.uid = uid;
		this.noVotes = noVotes;
		this.noOpinions = noOpinions;
		this.noArticles = noArticles;
		this.noConnections = noConnections;
		this.noInvites = noInvites;
		this.noReports = noReports;
		this.total = total;
		this.enabled = enabled;
	}


	@Override
	public String toString() {
		return "Counter [id=" + id + ", cid=" + cid + ", uid=" + uid + ", noVotes=" + noVotes + ", noOpinions="
				+ noOpinions + ", noArticles=" + noArticles + ", noConnections=" + noConnections + ", noInvites="
				+ noInvites + ", noReports=" + noReports + ", total=" + total + ", enabled=" + enabled + "]";
	}


	
	
	

	public int getId() {
		return id;
	}

	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
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
	public int getNoVotes() {
		return noVotes;
	}
	public int getNoOpinions() {
		return noOpinions;
	}

	public void setNoOpinions(int noOpinions) {
		this.noOpinions = noOpinions;
	}

	public int getNoArticles() {
		return noArticles;
	}

	public void setNoArticles(int noArticles) {
		this.noArticles = noArticles;
	}

	public int getNoReports() {
		return noReports;
	}
	public void setNoReports(int noReports) {
		this.noReports = noReports;
	}
	

	public void setNoVotes(int noVotes) {
		this.noVotes = noVotes;
	}
	public int getNoConnections() {
		return noConnections;
	}
	public void setNoConnections(int noConnections) {
		this.noConnections = noConnections;
	}

	public int getNoInvites() {
		return noInvites;
	}

	public void setNoInvites(int noInvites) {
		this.noInvites = noInvites;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
}
