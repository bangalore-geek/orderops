package com.gopaperless.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_user_roles")
public class UserRoles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tbl_user_roles_cid_gen")
	@SequenceGenerator(name = "tbl_user_roles_cid_gen", sequenceName = "tbl_user_roles_cid_seq")
	@Column(name = "cid")
	private int id;
	
	private int userId;
	
	private int roleId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
}
