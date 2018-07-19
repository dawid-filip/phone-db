package org.dawidfilip.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.dawidfilip.phone.model.Phone;
import org.springframework.stereotype.Service;

@Service
public class PhoneDAOImpl implements PhoneDAO, BaseAll<Phone, Long> {

	private static Logger LOGGER = Logger.getLogger(PhoneDAOImpl.class.getSimpleName());

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void add(Phone entity) {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		LOGGER.info("Entity " + entity.toString() + " has been added.");
	}

	public void update(Phone entity) {
		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();
		LOGGER.info("Entity " + entity.toString() + " has been updated.");
	}

	public void delete(Phone entity) {
		entityManager.getTransaction().begin();
		entityManager.remove(entity);
		entityManager.getTransaction().commit();
		LOGGER.info("Entity " + entity.toString() + " has been removed.");
	}

	public Phone find(Long key) {
		entityManager.getTransaction().begin();
		Phone phone = entityManager.find(Phone.class, key);
		entityManager.getTransaction().commit();
		LOGGER.info("Entity with " + key + " and content " + phone.toString() + " has been found.");
		return phone;
	}

	public List<Phone> findAll() {
		entityManager.getTransaction().begin();
		List<Phone> phones = entityManager.createNamedQuery(Phone.class.getSimpleName() + ".findAll", Phone.class)
				.getResultList();
		entityManager.getTransaction().commit();
		LOGGER.info("Entities " + this.getClass().getSimpleName() + " in size of " + phones.size() + " has been found.");
		return phones;
	}

}
