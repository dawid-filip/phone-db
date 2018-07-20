package org.dawidfilip.phone.app.configuration;

import javax.persistence.EntityManager;

import org.dawidfilip.bean.PhoneEntityManagerImpl;
import org.dawidfilip.dao.PhoneDAO;
import org.dawidfilip.dao.PhoneDAOImpl;
import org.dawidfilip.dao.UserDAO;
import org.dawidfilip.dao.UserDAOImpl;
import org.dawidfilip.phone.entity.Phone;
import org.dawidfilip.phone.entity.User;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApplicationBeanConfiguration {

	@Bean(name = "phoneEntityManager")
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public EntityManager phoneEntityManager() {
		return new PhoneEntityManagerImpl().getEntityManager("unitPhoneDB");
	}

	@Bean(name = "phoneDAO")
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public PhoneDAO<Phone, Long> phoneDAO() {
		PhoneDAO<Phone, Long> phoneDAO = new PhoneDAOImpl();
		phoneDAO.setEntityManager(phoneEntityManager());
		return phoneDAO;
	}
	
	@Bean(name = "userDAO")
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public UserDAO<User, String> userDAO() {
		UserDAO<User, String> userDAO = new UserDAOImpl();
		userDAO.setEntityManager(phoneEntityManager());
		return userDAO;
	}

}
