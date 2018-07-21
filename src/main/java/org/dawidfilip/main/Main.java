package org.dawidfilip.main;

import static org.dawidfilip.phone.common.PrintBulider.*;

import javax.persistence.EntityManager;

import org.dawidfilip.dao.PhoneDAOImpl;
import org.dawidfilip.phone.app.configuration.ApplicationBeanConfiguration;
import org.dawidfilip.phone.common.PhoneBuilder;
import org.dawidfilip.phone.entity.Phone;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

//@SpringBootApplication
public class Main {
	
	
	private static void typeTest(Class<?> type) {
		System.out.println(type);
		System.out.println(type.getName());
		System.out.println(type.getSimpleName());
	}
	
	public static void main(String[] args) {
		
		typeTest(Phone.class);
		
		
		//SpringApplication.run(Main.class, args);
		
		/*print("Starting application: '" + Main.class.getSimpleName() + "' class executing!");
		
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class); 
		
		EntityManager phoneEntityManager = context.getBean("entityManager", EntityManager.class);
		
		PhoneTestDao phoneTestDao = context.getBean("phoneTestDao", PhoneTestDao.class);
		phoneTestDao.persist(PhoneTestBuilder.creatDummyPhoneTest());
		
		
		phoneEntityManager.getTransaction().begin();
		phoneEntityManager.persist(PhoneTestBuilder.creatDummyPhoneTest());
		phoneEntityManager.getTransaction().commit();
		
		
		phoneEntityManager.getEntityManagerFactory().close();
		phoneEntityManager.close();
		
		print("Closing application: '" + Main.class.getSimpleName() + "'!");*/
		
	}	
	
}