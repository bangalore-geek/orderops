package com.gopaperless.repository.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.gopaperless.model.Role;
import com.gopaperless.repository.RoleDao;

@Repository
public class RoleDaoImpl  implements RoleDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session openSession() {
		return sessionFactory.openSession();
	}
	
	@Override
	public List<Role> getRoles() {
		Criteria criteria = sessionFactory.openSession().createCriteria(Role.class);
		return (List<Role>) criteria.list();
	}

}
