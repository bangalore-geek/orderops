package com.gopaperless.config.multitanent;

import javax.servlet.http.HttpSession;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class HeaderTenantIdentifierResolver implements CurrentTenantIdentifierResolver {

    @Value("${multitenant.defaultTenant}")
    String defaultTenant;

    @Override
    public String resolveCurrentTenantIdentifier() {
    	ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(attr != null){
        	HttpSession session = attr.getRequest().getSession(false); 
            String tenantId = (String) session.getAttribute("TENANT_ID");
            if (tenantId != null) {
                return tenantId;
            }
        }
        return defaultTenant;
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
