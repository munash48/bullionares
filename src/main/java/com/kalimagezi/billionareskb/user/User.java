package com.kalimagezi.billionareskb.user;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Entity
@Table(name="user_details")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="other_names")
	private String otherNames;
	@Column(unique = true)
	private String email;
	private String role ="ROLE_USER";
	@Column(length=60)
	private String password;
	private int catid;
	@Column(name="date_of_birth")
	private LocalDate birthDate;
	@Column(name="phone_nnumber")
	private String phoneNumber;
	@Column(name="image_link")
	private String imageLink;
	private Boolean enabled =true;
	private String profession;
	private String aboutme;
	private Date joinDate =new Date();
	
	
	public User() {

	}
	
	

	


	public User(int id, String firstName, String otherNames, String email, String role, String password, int catid,
			LocalDate birthDate, String phoneNumber, String imageLink, Boolean enabled, String profession,
			String aboutme, Date joinDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.otherNames = otherNames;
		this.email = email;
		this.role = role;
		this.password = password;
		this.catid = catid;
		this.birthDate = birthDate;
		this.phoneNumber = phoneNumber;
		this.imageLink = imageLink;
		this.enabled = enabled;
		this.profession = profession;
		this.aboutme = aboutme;
		this.joinDate = joinDate;
	}






	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", otherNames=" + otherNames + ", email=" + email
				+ ", role=" + role + ", password=" + password + ", catid=" + catid + ", birthDate=" + birthDate
				+ ", phoneNumber=" + phoneNumber + ", imageLink=" + imageLink + ", enabled=" + enabled + ", profession="
				+ profession + ", aboutme=" + aboutme + ", joinDate=" + joinDate + "]";
	}






	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getOtherNames() {
		return otherNames;
	}
	public void setOtherNames(String otherNames) {
		this.otherNames = otherNames;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {

		BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
		this.password = bCryptPasswordEncoder.encode(password);
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate date2) {
		this.birthDate = date2;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public int getCatid() {
		return catid;
	}

	public void setCatid(int catid) {
		this.catid = catid;
	}



	public String getProfession() {
		return profession;
	}



	public void setProfession(String profession) {
		this.profession = profession;
	}







	public Date getJoinDate() {
		return joinDate;
	}






	public String getAboutme() {
		return aboutme;
	}






	public void setAboutme(String aboutme) {
		this.aboutme = aboutme;
	}



	
}
