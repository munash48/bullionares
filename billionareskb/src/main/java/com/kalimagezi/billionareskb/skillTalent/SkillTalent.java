package com.kalimagezi.billionareskb.skillTalent;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SkillTalent {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int uid;
	private String name1;
	private String name2;
	private String name3;
	private String name4;
	private String name5;
	private String description;
	private boolean enabled=true;
	
	
	public SkillTalent() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SkillTalent(int id, int uid, String name1, String name2, String name3, String name4, String name5,
			String description, boolean enabled) {
		super();
		this.id = id;
		this.uid = uid;
		this.name1 = name1;
		this.name2 = name2;
		this.name3 = name3;
		this.name4 = name4;
		this.name5 = name5;
		this.description = description;
		this.enabled = enabled;
	}


	@Override
	public String toString() {
		return "SkillTalent [id=" + id + ", uid=" + uid + ", name1=" + name1 + ", name2=" + name2 + ", name3=" + name3
				+ ", name4=" + name4 + ", name5=" + name5 + ", description=" + description + ", enabled=" + enabled
				+ "]";
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


	public String getName1() {
		return name1;
	}


	public void setName1(String name1) {
		this.name1 = name1;
	}


	public String getName2() {
		return name2;
	}


	public void setName2(String name2) {
		this.name2 = name2;
	}


	public String getName3() {
		return name3;
	}


	public void setName3(String name3) {
		this.name3 = name3;
	}


	public String getName4() {
		return name4;
	}


	public void setName4(String name4) {
		this.name4 = name4;
	}


	public String getName5() {
		return name5;
	}


	public void setName5(String name5) {
		this.name5 = name5;
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

	
}
