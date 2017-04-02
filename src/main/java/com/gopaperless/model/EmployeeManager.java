package com.gopaperless.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblempmanager") 
public class EmployeeManager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cid", nullable = false)
	private Long id;
	
	@Column(name = "userid", nullable = false)
	private Long userId;
	
	@Column(name = "managerid", nullable = false)
	private int managerId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
}
