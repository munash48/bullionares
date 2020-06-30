package com.kalimagezi.billionareskb.home;

import java.util.Date;

public class Dmessage {
	
	private int duid;
	private String dfullName;
	private String dimageLink;
	private Date dmdate;
	private String dmessage;
	public Dmessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dmessage(int duid, String dfullName, String dimageLink, Date dmdate, String dmessage) {
		super();
		this.duid = duid;
		this.dfullName = dfullName;
		this.dimageLink = dimageLink;
		this.dmdate = dmdate;
		this.dmessage = dmessage;
	}
	@Override
	public String toString() {
		return "Dmessage [duid=" + duid + ", dfullName=" + dfullName + ", dimageLink=" + dimageLink + ", dmdate="
				+ dmdate + ", dmessage=" + dmessage + "]";
	}
	public int getDuid() {
		return duid;
	}
	public void setDuid(int duid) {
		this.duid = duid;
	}
	public String getDfullName() {
		return dfullName;
	}
	public void setDfullName(String dfullName) {
		this.dfullName = dfullName;
	}
	public String getDimageLink() {
		return dimageLink;
	}
	public void setDimageLink(String dimageLink) {
		this.dimageLink = dimageLink;
	}
	public Date getDmdate() {
		return dmdate;
	}
	public void setDmdate(Date dmdate) {
		this.dmdate = dmdate;
	}
	public String getDmessage() {
		return dmessage;
	}
	public void setDmessage(String dmessage) {
		this.dmessage = dmessage;
	}
	
	
	

}
