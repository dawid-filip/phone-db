package org.dawidfilip.bean;

public interface PhoneEntityManager {
	void create();
	void close();
	
	void begin();
	void commit();
	void rollback();
	
	void persist(Object entity);
}
