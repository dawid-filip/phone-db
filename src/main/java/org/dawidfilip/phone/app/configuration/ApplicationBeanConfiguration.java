package org.dawidfilip.phone.app.configuration;

import javax.persistence.EntityManager;

import org.dawidfilip.bean.PhoneEntityManagerImpl;
import org.dawidfilip.dao.PhoneDAOImpl;
import org.dawidfilip.dao.UserDAOImpl;
import org.dawidfilip.phone.entity.Phone;
import org.dawidfilip.phone.entity.User;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

//@Lazy(value = false)
@Configuration
public class ApplicationBeanConfiguration {

	@Bean(name = "phoneEntityManager")
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public EntityManager phoneEntityManager() {
		return new PhoneEntityManagerImpl().getEntityManager("unitPhoneDB");
	}

	@Bean(name = "phoneDAO")
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public PhoneDAOImpl phoneDAO() {
		PhoneDAOImpl phoneDAO = new PhoneDAOImpl();
		phoneDAO.setEntityManager(phoneEntityManager());
		phoneDAO.setType(Phone.class);
		return phoneDAO;
	}
	
	@Bean(name = "userDAO")
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public UserDAOImpl userDAO() {
		UserDAOImpl userDAO = new UserDAOImpl();
		userDAO.setEntityManager(phoneEntityManager());
		userDAO.setType(User.class);
		return userDAO;
	}
	
}
