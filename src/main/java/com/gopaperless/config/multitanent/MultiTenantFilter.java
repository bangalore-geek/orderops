package com.gopaperless.config.multitanent;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.gopaperless.model.AccountInfo;
import com.gopaperless.service.AccountManager;

@Component
public class MultiTenantFilter implements Filter {

	@Value("${multitenant.defaultTenant}")
	String defaultTenant;

	@Autowired
	private AccountManager accountManager;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		String accountCode = getAccountCodeFromURI(req);
		HttpSession session=req.getSession();  
		if (accountCode != null) {
			session.setAttribute("TENANT_ID", accountCode);
		} else {
			session.setAttribute("TENANT_ID", defaultTenant);
		}
		chain.doFilter(request, response);
	}

	public String getAccountCodeFromURI(HttpServletRequest request) {
		String serverName = request.getServerName();
		String accountCode = "";
		if (accountCode.isEmpty()) {
			AccountInfo accountInfo = accountManager.getAccountInfo(serverName);
			if (accountInfo != null) {
				accountCode = serverName;
			}
		}
		return accountCode;
	}

	@Override
	public void destroy() {

	}
}
