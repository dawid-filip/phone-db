package info.dawidfilip.phone.app.configuration;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import info.dawidfilip.bean.PhoneEntityManagerImpl;
import info.dawidfilip.dao.PhoneDAOImpl;
import info.dawidfilip.dao.UserDAOImpl;
import info.dawidfilip.phone.entity.Phone;
import info.dawidfilip.phone.entity.User;
import info.dawidfilip.service.PhoneServiceImpl;

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
	
	@Bean(name = "phoneServiceImpl")
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public PhoneServiceImpl phoneServiceImpl() {
		PhoneServiceImpl phoneServiceImpl = new PhoneServiceImpl();
		return phoneServiceImpl;
	}
	
}
