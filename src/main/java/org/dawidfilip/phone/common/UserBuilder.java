package org.dawidfilip.phone.common;

import java.util.Date;
import java.util.Random;

import org.dawidfilip.phone.entity.User;

public class UserBuilder {

	public static User creatDummyUser() {
		return new User("dawid", "password", "Admin", new Date(System.currentTimeMillis())); 
	}
	
	public static User creatDummyRandomUser() {
		return new User("dawid" + randomLong(), randomLong() + "password" + randomLong(), "Admin", new Date(System.currentTimeMillis())); 
	}
	
	
	private static long randomLong() {
		return new Random().nextLong();
	}
	
}
