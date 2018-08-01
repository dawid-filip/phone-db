package info.dawidfilip.phone.app.configuration;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import info.dawidfilip.bean.PhoneEntityManagerImpl;
import info.dawidfilip.dao.PhoneDAOImpl;
import info.dawidfilip.phone.entity.Phone;
import info.dawidfilip.service.PhoneService;
import info.dawidfilip.service.PhoneServiceImpl;

//@Lazy(value = false)
@Configuration
public class ApplicationBeanConfiguration {

	@Bean(name = "phoneEntityManager")
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public EntityManager phoneEntityManager() {
		return new PhoneEntityManagerImpl().getEntityManager("unitPhoneDB");
	}

	@Bean(name = "phoneDAOImpl")
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public PhoneDAOImpl phoneDAO() {
		PhoneDAOImpl phoneDAO = new PhoneDAOImpl();
		phoneDAO.setEntityManager(phoneEntityManager());
		phoneDAO.setType(Phone.class);
		return phoneDAO;
	}
	
	@Bean(name = "phoneServiceImpl")
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public PhoneService PhoneServiceImpl() {
		PhoneService phoneServiceImpl = new PhoneServiceImpl();
		phoneServiceImpl.setPhoneDAOImpl(phoneDAO());
		return phoneServiceImpl;
	}
	
}
