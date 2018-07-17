package org.dawidfilip.phone.app.configuration;

import javax.persistence.EntityManager;

import org.dawidfilip.bean.PhoneEntityManager;
import org.dawidfilip.bean.PhoneEntityManagerImpl;
import org.dawidfilip.dao.PhoneTestDao;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApplicationBeanConfiguration {
	
	@Bean(name = "phoneEntityManager")
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public PhoneEntityManager phoneEntityManager() {
		return new PhoneEntityManagerImpl();
	}
	
	@Bean(name = "entityManager")
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public EntityManager entityManager() {
		return PhoneEntityManagerImpl.getPhoneEntityManager();
	}
	
	@Bean(name = "phoneTestDao")
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public PhoneTestDao phoneTestDao() {
		PhoneTestDao phoneTestDao = new PhoneTestDao();
		phoneTestDao.setEntityManager(entityManager());
		return phoneTestDao;
	}
	
	
	
}
