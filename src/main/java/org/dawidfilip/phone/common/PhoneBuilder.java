package org.dawidfilip.phone.common;

import java.util.ArrayList;
import java.util.List;

import org.dawidfilip.phone.model.Phone;

public class PhoneBuilder {
	
	private PhoneBuilder() {
	}
	
	public static Phone creatDummyPhoneTest() {
		return new Phone("Sony", "Xperia Z3 Compact", 2299.99);
	}
	
	public static List<Phone> commitDummyPhoneList() {
		Phone phone1 = new Phone("Sony", "Xperia Z1 Compact", 1299.99);
		Phone phone2 = new Phone("LG", "G6", 1622.89);
		Phone phone3 = new Phone("Xiaomi", "Redmi X5", 699.00);
		Phone phone4 = new Phone("Nokia", "3310", 99.00);
		Phone phone5 = new Phone("Huwai", "PS", 999.00);

		List<Phone> phones = new ArrayList<Phone>();
		phones.add(phone1);
		phones.add(phone2);
		phones.add(phone3);
		phones.add(phone4);
		phones.add(phone5);
		
		return phones;
	}

}
