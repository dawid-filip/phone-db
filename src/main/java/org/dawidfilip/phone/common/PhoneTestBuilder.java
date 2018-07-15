package org.dawidfilip.phone.common;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.dawidfilip.phone.model.PhoneTest;

public class PhoneTestBuilder {
	
	private PhoneTestBuilder() {
	}
	
	public static List<PhoneTest> commitDummyPhoneTests(EntityManager entityManager) {
//		PhoneTest phone1 = new PhoneTest(1L, "Sony", "Xperia Z1 Compact", 1299.99);
//		PhoneTest phone2 = new PhoneTest(2L, "LG", "G6", 1622.89);
		
		PhoneTest phone1 = new PhoneTest("Sony", "Xperia Z1 Compact", 1299.99);
		PhoneTest phone2 = new PhoneTest("LG", "G6", 1622.89);
		PhoneTest phone3 = new PhoneTest("Xiaomi", "Redmi X5", 699.00);
		
		List<PhoneTest> phones = new ArrayList<PhoneTest>();
		phones.add(phone1);
		phones.add(phone2);
		phones.add(phone3);
		
		persist(entityManager, phones);
		
		return phones;
	}
	private static void persist(EntityManager entityManager, List<PhoneTest> phones) {
		entityManager.getTransaction().begin();
		for (PhoneTest p : phones) {
			entityManager.persist(p);
		}
		entityManager.getTransaction().commit();
	}

}
