package com.gopaperless.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.gopaperless.model.User;

@Repository
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session openSession() {
		return sessionFactory.openSession();
	}

	@SuppressWarnings("unchecked")
	public User getUser(String login) {
		List<User> userList = new ArrayList<User>();
		Query query = openSession().createQuery("from com.gopaperless.model.User u where u.userName = :login");
		query.setParameter("login", login);
		userList = query.list();
		if (userList.size() > 0)
			return userList.get(0);
		else
			return null;
	}

	public User getLoggedInUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		org.springframework.security.core.userdetails.User authuser = (authentication != null
				&& authentication.getPrincipal() instanceof org.springframework.security.core.userdetails.User)
						? (org.springframework.security.core.userdetails.User) authentication.getPrincipal() : null;
		return authuser == null ? null : getUser(authuser.getUsername());
	}

	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		Criteria criteria = sessionFactory.openSession().createCriteria(User.class);
		return (List<User>) criteria.list();
	}

	public void save(User user) {
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		session.saveOrUpdate(user);
		transaction.commit();
		session.close();
	}

	public User getUserById(int userId) {
		Criteria criteria = sessionFactory.openSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("id", userId));
		return (User) criteria.uniqueResult();
	}
}