package org.dawidfilip.phone.main;

import static org.dawidfilip.common.PrintBulider.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		print("Starting application: '" + Main.class.getSimpleName() + "' class executing!");
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unitPhoneDB");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		
		entityManager.close();
		entityManagerFactory.close();
		
		
	}	

}