package com.gopaperless.bean;

public class UserProfileBean {
	
	private String firstName;
	
	private String lastName;
	
	private String userName;
	
	private String email;
	
	private boolean active;

	private int salesManagerId;
	
	private int roleId;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getSalesManagerId() {
		return salesManagerId;
	}

	public void setSalesManagerId(int salesManagerId) {
		this.salesManagerId = salesManagerId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	@Override
	public String toString() {
		String str = "[firstName:" + firstName+", lastName:" +lastName + ", userName:" + userName+ ", email: "+email+ ", active: "+active+ ", salesManagerId: "+salesManagerId+ ", roleId: "+roleId+ "]";
		return str;
	}
}
