package com.gopaperless.repository.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gopaperless.repository.PublicDao;

@Repository
public class PublicDaoImpl implements PublicDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getObjects(Class<T> clazz) {
		return sessionFactory.getCurrentSession().createCriteria(clazz).list();
	}

	public <T> T getObject(Class<T> clazz, Serializable id) {
		return (T) sessionFactory.getCurrentSession().load(clazz, id);
	}

	public void saveObject(Object o) {
		sessionFactory.getCurrentSession().saveOrUpdate(o);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see folklore.dao.DAO#removeObject(java.lang.Class, java.io.Serializable)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void removeObject(Class clazz, Serializable id) {
		sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().load(clazz, id));
	}

	public <T> T getObjectOrNull(Class<T> clazz, Serializable id) {
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	@Override
	public <T> List<T> getObjects(Class<T> clazz, String orderByField) {
		return null;
	}

}
