package org.dawidfilip.dao;


import javax.persistence.EntityManager;

import org.dawidfilip.phone.model.PhoneTest;
import org.springframework.stereotype.Service;

@Service
public class PhoneTestDao {
		
	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void persist(PhoneTest phoneTest) {
		entityManager.getTransaction().begin();
		entityManager.persist(phoneTest); 
		entityManager.getTransaction().commit();
	}
	
}
