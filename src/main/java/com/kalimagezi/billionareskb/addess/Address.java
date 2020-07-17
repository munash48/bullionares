package com.kalimagezi.billionareskb.addess;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int uid;
	private String country;
	private String district;
	private String division;
	private String village;
	private String street;
	@Column(name="box_number")
	private String boxNumber;
	private boolean enabled=true;
	
	
	
	
	
	public Address() {

		// TODO Auto-generated constructor stub
	}
	
	
	public Address(int id, int uid, String country, String district, String division, String village, String street,
			String boxNumber, boolean enabled) {
		super();
		this.id = id;
		this.uid = uid;
		this.country = country;
		this.district = district;
		this.division = division;
		this.village = village;
		this.street = street;
		this.boxNumber = boxNumber;
		this.enabled = enabled;
	}


	@Override
	public String toString() {
		return "Address [id=" + id + ", uid=" + uid + ", country=" + country + ", district=" + district + ", division="
				+ division + ", village=" + village + ", street=" + street + ", boxNumber=" + boxNumber + ", enabled="
				+ enabled + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getBoxNumber() {
		return boxNumber;
	}
	public void setBoxNumber(String boxNumber) {
		this.boxNumber = boxNumber;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}
	
	
	
}
