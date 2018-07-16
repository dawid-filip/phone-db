package org.dawidfilip.phone.main;

import static org.dawidfilip.phone.common.PrintBulider.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.dawidfilip.bean.PhoneEntityManager;
import org.dawidfilip.phone.app.configuration.ApplicationConfiguration;
import org.dawidfilip.phone.common.PhoneTestBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		print("Starting application: '" + Main.class.getSimpleName() + "' class executing!");
		
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class); 
		
		EntityManager phoneEntityManager = context.getBean("entityManager", EntityManager.class);
		
		
		phoneEntityManager.getTransaction().begin();
		phoneEntityManager.persist(PhoneTestBuilder.creatDummyPhoneTest());
		phoneEntityManager.getTransaction().commit();
		
		
		phoneEntityManager.getEntityManagerFactory().close();
		phoneEntityManager.close();
		
		
//		PhoneEntityManager phoneEntityManager = context.getBean("phoneEntityManager", PhoneEntityManager.class);
//		phoneEntityManager.create();
//		
//		PhoneTestBuilder.commitDummyPhoneTests(phoneEntityManager);
//		phoneEntityManager.close();
	}	
	
}