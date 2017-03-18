package com.gopaperless;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

import com.gopaperless.config.multitanent.MultiTenantFilter;

@SpringBootApplication
@EnableCaching
public class GopaperlessApplication {

	@Autowired
	AutowireCapableBeanFactory beanFactory;

	public static void main(String[] args) {
		SpringApplication.run(GopaperlessApplication.class, args);
	}

	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory() {
		return new HibernateJpaSessionFactoryBean();
	}

	@Bean
	public FilterRegistrationBean myFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		Filter tenantFilter = new MultiTenantFilter();
		beanFactory.autowireBean(tenantFilter);
		registration.setFilter(tenantFilter);
		registration.addUrlPatterns("/*");
		return registration;
	}

	@Bean
	public CacheManager cacheManager() {
		ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager("tenants");
		return cacheManager;
	}
}
