package com.gopaperless.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gopaperless.model.AccountInfo;
import com.gopaperless.repository.AccountDao;

@Repository
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session openSession() {
		return sessionFactory.withOptions().tenantIdentifier("public").openSession();
	}

	@Override
	public AccountInfo getAccountInfoForDomain(String code) {
		Criteria criteria = openSession().createCriteria(AccountInfo.class);
		criteria.add(Restrictions.eq("domainName", code));
		return (AccountInfo) criteria.uniqueResult();
	}

	@Override
	public AccountInfo getAccountInfoByAccessId(String accessId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountInfo getAccountInfo(String accountCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountInfo> getAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountInfo generateAccessKey(AccountInfo accountInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createAccessKey(String domainName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createAccessId(String domainName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSchema(AccountInfo accountInfo) {
		// TODO Auto-generated method stub

	}

}
