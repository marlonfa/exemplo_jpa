package view;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;

public class EntityManagerProvider {

	private static EntityManagerProvider instance;
	private static EntityManager entityManager;

	public static EntityManagerProvider getInstance() {
		if (instance == null) {
			instance = new EntityManagerProvider();
		}
		return instance;
	}

	private EntityManagerProvider() {
		entityManager = getEntityManager();
	}

	public static EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}
}
