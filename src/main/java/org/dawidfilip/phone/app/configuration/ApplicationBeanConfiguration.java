package org.dawidfilip.phone.app.configuration;

import javax.persistence.EntityManager;

import org.dawidfilip.bean.PhoneEntityManagerImpl;
import org.dawidfilip.dao.PhoneDAO;
import org.dawidfilip.dao.PhoneDAOImpl;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApplicationBeanConfiguration {

	@Bean(name = "phoneEntityManager")
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public EntityManager phoneEntityManager() {
		return PhoneEntityManagerImpl.getEntityManager("unitPhoneDB");
	}

	@Bean(name = "phoneDAOImpl")
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public PhoneDAO phoneTestDao() {
		PhoneDAOImpl phoneTestDao = new PhoneDAOImpl();
		phoneTestDao.setEntityManager(phoneEntityManager());
		return phoneTestDao;
	}

}
