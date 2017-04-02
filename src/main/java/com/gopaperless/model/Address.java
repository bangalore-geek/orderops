package com.gopaperless.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbladdress") 
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cid", nullable = false)
	private Long id;
	
	@Column(name = "userid", nullable = false)
	private int userId;

	@Column(name = "country", nullable = false)
	private int country;
	
	@Column(name = "state", nullable = false)
	private int state;
	
	@Column(name = "district", nullable = false)
	private int district;
	
	@Column(name = "city", nullable = false)
	private int city;
	
	@Column(name = "pin", nullable = false)
	private int pin;
	
	@Column(name = "mobile", nullable = false)
	private String mobile;
	
	@Column(name = "landline", nullable = false)
	private String landline;
	
	@Column(name = "email", nullable = false)
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCountry() {
		return country;
	}

	public void setCountry(int country) {
		this.country = country;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getDistrict() {
		return district;
	}

	public void setDistrict(int district) {
		this.district = district;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getLandline() {
		return landline;
	}

	public void setLandline(String landline) {
		this.landline = landline;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
