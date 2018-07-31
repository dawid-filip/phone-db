package info.dawidfilip.bean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy(value = false)
public final class PhoneEntityManagerImpl implements PhoneEntityManager {

	public PhoneEntityManagerImpl() {
	}

	public EntityManager getEntityManager(String persistenceUnitName) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

}
