package org.dawidfilip.phone.common;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.dawidfilip.bean.PhoneEntityManager;
import org.dawidfilip.phone.model.PhoneTest;

public class PhoneTestBuilder {
	
	private PhoneTestBuilder() {
	}
	
	public static PhoneTest creatDummyPhoneTest() {
		return new PhoneTest("Sony", "Xperia Z3 Compact", 2299.99, BigDecimal.ZERO);
	}
	
	public static List<PhoneTest> commitDummyPhoneTests(PhoneEntityManager phoneEntityManager) {
//		PhoneTest phone1 = new PhoneTest(1L, "Sony", "Xperia Z1 Compact", 1299.99);
//		PhoneTest phone2 = new PhoneTest(2L, "LG", "G6", 1622.89);
		
		PhoneTest phone1 = new PhoneTest("Sony", "Xperia Z1 Compact", 1299.99, BigDecimal.ZERO);
		PhoneTest phone2 = new PhoneTest("LG", "G6", 1622.89, new BigDecimal("111.99"));
		PhoneTest phone3 = new PhoneTest("Xiaomi", "Redmi X5", 699.00, BigDecimal.TEN);
		
		List<PhoneTest> phones = new ArrayList<PhoneTest>();
		phones.add(phone1);
		phones.add(phone2);
		phones.add(phone3);
		
		persist(phoneEntityManager, phones);
		
		return phones;
	}
	private static void persist(PhoneEntityManager phoneEntityManager, List<PhoneTest> phones) {
		phoneEntityManager.begin();
		for (PhoneTest p : phones) {
			phoneEntityManager.persist(p);
		}
		phoneEntityManager.commit();
	}

}
