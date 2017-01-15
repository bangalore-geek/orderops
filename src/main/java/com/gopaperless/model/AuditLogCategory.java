package com.gopaperless.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tblauditcategory")
public class AuditLogCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tblauditcategory_cid_gen")
	@SequenceGenerator(name = "tblauditcategory_cid_gen", sequenceName = "tblauditcategory_cid_seq")
	@Column(name = "cid")
	private int id;
	private String code;
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
