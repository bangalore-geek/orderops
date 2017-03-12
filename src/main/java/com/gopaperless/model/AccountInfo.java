package com.gopaperless.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tblaccountinfo")
public class AccountInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String ACCOUNT_INFO_CACHE = "accountInfo";

	public static final int ACCOUNT_INFO_CACHE_TIME_TO_LIVE = 900;

	public static final String MAJORDOMO = "majordomo";

	public static final String MAJORDOMO_SCHEMA = "public";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tblaccountinfo_cid__gen")
	@SequenceGenerator(name = "tblaccountinfo_cid__gen", sequenceName = "tblaccountinfo_cid_seq")
	@Column(name = "cid")
	private int id;

	@Column(name = "accountid")
	private Integer accountId;

	@Column(name = "domainname")
	private String domainName;

	@Column(name = "schemaname")
	private String schemaName;

	@Column(name = "schemausername")
	private String schemaUserName;

	@Column(name = "schemapassword")
	private String schemaPassword;

	@Column(name = "user_schema")
	private boolean userSchema;

	private Boolean enabled = false;

	@Column(name = "accessid")
	private String accessId;

	@Column(name = "accesskey")
	private String accessKey;

	@Column(name = "dbserver")
	private String dbServerCode;

	private String plan;

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isUserSchema() {
		return userSchema;
	}

	public void setUserSchema(boolean userSchema) {
		this.userSchema = userSchema;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSchemaName() {
		return schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	public String getSchemaUserName() {
		return schemaUserName;
	}

	public void setSchemaUserName(String schemaUserName) {
		this.schemaUserName = schemaUserName;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getSchemaPassword() {
		return schemaPassword;
	}

	public void setSchemaPassword(String schemaPassword) {
		this.schemaPassword = schemaPassword;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getAccessId() {
		return accessId;
	}

	public void setAccessId(String accessId) {
		this.accessId = accessId;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getDbServerCode() {
		return dbServerCode;
	}

	public void setDbServerCode(String dbServerCode) {
		this.dbServerCode = dbServerCode;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getPlan() {
		return plan;
	}

}
