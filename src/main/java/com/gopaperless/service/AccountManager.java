package com.gopaperless.service;

import java.util.List;

import com.gopaperless.model.AccountInfo;

public interface AccountManager {

	AccountInfo getAccountInfoForDomain(String code);

	AccountInfo getAccountInfoByAccessId(String accessId);

	AccountInfo getAccountInfo(String accountCode);

	List<AccountInfo> getAccounts();

	AccountInfo generateAccessKey(AccountInfo accountInfo);

	String createAccessKey(String domainName);

	String createAccessId(String domainName);

	void deleteSchema(AccountInfo accountInfo);

}
