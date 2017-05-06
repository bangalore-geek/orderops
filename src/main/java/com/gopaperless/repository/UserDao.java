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

import com.gopaperless.bean.UserProfileBean;
import com.gopaperless.model.Address;
import com.gopaperless.model.Email;
import com.gopaperless.model.EmployeeManager;
import com.gopaperless.model.PasswordResetToken;
import com.gopaperless.model.User;
import com.gopaperless.model.UserProfile;
import com.gopaperless.model.UserRoles;
import com.gopaperless.service.MailService;
import com.gopaperless.utls.AppUtils;

@Repository
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private MailService mailService;

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

	public UserProfile getUserProfileById(int userId) {
		Criteria criteria = sessionFactory.openSession().createCriteria(UserProfile.class);
		criteria.add(Restrictions.eq("userId", userId));
		return (UserProfile) criteria.uniqueResult();
	}

	public Address getUserAddressById(int userId) {
		Criteria criteria = sessionFactory.openSession().createCriteria(Address.class);
		criteria.add(Restrictions.eq("userId", userId));
		return (Address) criteria.uniqueResult();
	}

	public void saveUserDetails(UserProfileBean userProfileBean) {
		// user
		User thisUser = new User();
		thisUser.setUserName(userProfileBean.getUserName());
		thisUser.setEmail(userProfileBean.getEmail());
		thisUser.setName(userProfileBean.getFirstName());
		String unEncryptPass = AppUtils.getRandorPassword(userProfileBean.getFirstName());
		thisUser.setPassword(AppUtils.encryptPassword(unEncryptPass));
		thisUser.setBriefcasePassword(AppUtils.encryptPassword(unEncryptPass));

		// user profile
		UserProfile thisUserProfile = new UserProfile();
		thisUserProfile.setFirstName(userProfileBean.getFirstName());
		thisUserProfile.setLastName(userProfileBean.getLastName());
		thisUserProfile.setUserId(thisUser.getId());

		// manager
		EmployeeManager thisEmployeeManager = new EmployeeManager();
		thisEmployeeManager.setManagerId(userProfileBean.getSalesManagerId());

		// address
		Address address = new Address();
		address.setEmail(userProfileBean.getEmail());

		// role mapping
		UserRoles roles = new UserRoles();

		Session session = openSession();

		Transaction transaction = session.beginTransaction();
		transaction.begin();
		session.saveOrUpdate(thisUser);

		roles.setUserId(thisUser.getId());
		roles.setRoleId(userProfileBean.getRoleId());
		session.saveOrUpdate(roles);

		address.setUserId(thisUser.getId());
		session.saveOrUpdate(address);

		thisUserProfile.setUserId(thisUser.getId());
		thisUserProfile.setAddress(address.getId());

		session.saveOrUpdate(thisUserProfile);

		thisEmployeeManager.setUserId(new Long(thisUser.getId()));
		session.saveOrUpdate(thisEmployeeManager);

		transaction.commit();
		session.close();

		Email thisEmail = new Email();
		thisEmail.setTo(userProfileBean.getEmail());
		thisEmail.setSubject("Welcome to OrderOPS");
		thisEmail.setBody("<BR>Welcome " + userProfileBean.getFirstName()
				+ ",<BR><P>Please find your password below to login to OrderOPS</P><BR><P>Passowrd : " + unEncryptPass);
		mailService.sendEmail(thisEmail);

	}
	
	
	public void saveToken(int userId, String token) {
		PasswordResetToken passwordResetToken = new PasswordResetToken();
		passwordResetToken.setToken(token);
		passwordResetToken.setUserId(userId);
		openSession().saveOrUpdate(passwordResetToken);
	}

	public PasswordResetToken getPasswordResetToken(int userId, String token) {
		Criteria criteria = sessionFactory.openSession().createCriteria(PasswordResetToken.class);
		criteria.add(Restrictions.eq("userId", userId));
		return (PasswordResetToken) criteria.uniqueResult();
	}
	
	public User getUserByEmail(String email) {
		Criteria criteria = sessionFactory.openSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("email", email));
		return (User) criteria.uniqueResult();
	}

}