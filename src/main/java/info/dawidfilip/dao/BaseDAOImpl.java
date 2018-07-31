package info.dawidfilip.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

public abstract class BaseDAOImpl implements BaseDAO {
	
	private static Logger LOGGER = Logger.getLogger(BaseDAOImpl.class.getSimpleName());
	
	protected EntityManager entityManager;
	//private Class<?> type;
	private String simpleClassName;
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	public void setType(Class<?> type) {
		//this.type = type;
		setSimpleClassName(type);
	}
	
	private void setSimpleClassName(Class<?> type) {
		this.simpleClassName = type.getSimpleName();
	}
	
	
	public void add(Object entity) {
		try {
			entityManager.getTransaction().begin();	
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
		} catch (EntityExistsException e) {
			entityManager.getTransaction().rollback();
		}
		LOGGER.info("Entity " + entity.toString() + " has been added.");
	}
	
	public void addAll(List<Object> entities) {
		LOGGER.info("Adding all " + entities != null ? entities.size() : null + " entities...");
		for (Object entity : entities) {
			add(entity);
		}
	}

	public void update(Object entity) {
		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();
		LOGGER.info("Entity " + entity.toString() + " has been updated.");
	}
	
	public void updateAll(List<Object> entities) {
		LOGGER.info("Updating all " + entities != null ? entities.size() : null + " entities...");
		for (Object entity : entities) {
			update(entity);
		}
	}

	//@Transactional
	public void delete(Object entity) {
		entityManager.remove(entity);
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.getTransaction().rollback();
//			entityManager.getEntityManagerFactory().close();
//			entityManager.close();
		}
		LOGGER.info("Entity " + entity.toString() + " has been removed.");
	}
	
	public void deleteAll(List<Object> entities) {
		for (Object entity : entities) {
			delete(entity);
		}
		LOGGER.info("All listed " + entities != null ? entities.size() : null + " " + simpleClassName + " entities has been deleted.");
	}
	public void deleteAll() {
		int size = findAll().size();
		entityManager.getTransaction().begin();
		entityManager.createNamedQuery(simpleClassName + ".deleteAll");
		entityManager.getTransaction().commit();
		LOGGER.info("All " + size + " " + simpleClassName + " entities has been deleted.");
	}
	
	public void deleteById(Object key) {
		entityManager.getTransaction().begin();
		Object object = entityManager.createNamedQuery(simpleClassName + ".delete")
				.setParameter("id", key)
				.getSingleResult();
		entityManager.getTransaction().commit();
		LOGGER.info("Entity " + simpleClassName + " with " + key + " key has been deleted.");
	}
	
	public List<?> findAll() {
		entityManager.getTransaction().begin();
		List<?> objects = entityManager.createNamedQuery(simpleClassName + ".findAll")
				.getResultList();
		entityManager.getTransaction().commit();
		LOGGER.info("Entities " + simpleClassName + " in size of " + objects.size() + " has been found.");
		return objects;
	}

	public Object findById(Object key) {
		entityManager.getTransaction().begin();
		Object object = entityManager.createNamedQuery(simpleClassName + ".find")
				.setParameter("id", key)
				.getSingleResult();
		entityManager.getTransaction().commit();
		
		if (object==null) 
			object = new Object();
		
		LOGGER.info("Entity with " + key + " and content " + object.toString() + " has been found.");
		return object;
	}
	
}

