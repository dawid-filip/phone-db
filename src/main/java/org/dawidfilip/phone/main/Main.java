package org.dawidfilip.phone.main;

import static org.dawidfilip.phone.common.PrintBulider.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.dawidfilip.phone.common.PhoneTestBuilder;

public class Main {

	public static void main(String[] args) {
		print("Starting application: '" + Main.class.getSimpleName() + "' class executing!");
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unitPhoneDB");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		PhoneTestBuilder.commitDummyPhoneTests(entityManager);
		
		entityManager.close();
		entityManagerFactory.close();
		
		
	}	

}