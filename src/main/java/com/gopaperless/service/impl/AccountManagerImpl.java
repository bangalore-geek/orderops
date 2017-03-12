package com.gopaperless.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopaperless.model.AccountInfo;
import com.gopaperless.repository.AccountDao;
import com.gopaperless.service.AccountManager;

@Service
public class AccountManagerImpl implements AccountManager {
	
	@Autowired
	private AccountDao accountDao;

	@Override
	public AccountInfo getAccountInfoForDomain(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountInfo getAccountInfoByAccessId(String accessId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountInfo getAccountInfo(String accountCode) {
		return accountDao.getAccountInfoForDomain(accountCode);
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
