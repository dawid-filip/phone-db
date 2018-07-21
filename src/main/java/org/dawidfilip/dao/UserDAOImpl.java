package org.dawidfilip.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.dawidfilip.phone.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserDAOImpl extends BaseDMLDAO { //implements UserDAO<User, String> {

	private static Logger LOGGER = Logger.getLogger(UserDAOImpl.class.getSimpleName());

	public User find(String key) {
		entityManager.getTransaction().begin();
		User user = entityManager.find(User.class, key);
		entityManager.getTransaction().commit();
		
		if (user==null) 
			user = new User();
		
		LOGGER.info("Entity with " + key + " and content " + user.toString() + " has been found.");
		return user;
	}

	public List<User> findAll() {
		entityManager.getTransaction().begin();
		List<User> users = entityManager.createNamedQuery(User.class.getSimpleName() + ".findAll", User.class)
				.getResultList();
		entityManager.getTransaction().commit();
		LOGGER.info("Entities " + this.getClass().getSimpleName() + " in size of " + users.size() + " has been found.");
		return users;
	}

}
