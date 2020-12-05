package com.kalimagezi.billionareskb.category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int catid;
	@Column(name="cat_name")
	private String catName;
	private String description;
	private int noMembers;
	private boolean enabled=true;
	
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Category(int catid, String catName, String description, int noMembers, boolean enabled) {
		super();
		this.catid = catid;
		this.catName = catName;
		this.description = description;
		this.noMembers = noMembers;
		this.enabled = enabled;
	}




	@Override
	public String toString() {
		return "Category [catid=" + catid + ", catName=" + catName + ", description=" + description + ", noMembers="
				+ noMembers + ", enabled=" + enabled + "]";
	}


	public int getCatid() {
		return catid;
	}


	public void setCatid(int catid) {
		this.catid = catid;
	}


	public String getCatName() {
		return catName;
	}


	public void setCatName(String catName) {
		this.catName = catName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}




	public int getNoMembers() {
		return noMembers;
	}




	public void setNoMembers(int noMembers) {
		this.noMembers = noMembers;
	}
	
	
	
	
	
	
}
