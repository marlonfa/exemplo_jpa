package controller;

import javax.persistence.EntityManager;

import model.Funcionario;
import view.EntityManagerProvider;

public class JPAController {
	
	private static EntityManager entityManager;
	
	public JPAController() {
		EntityManagerProvider.getInstance();
		entityManager = EntityManagerProvider.getEntityManager();
	}

	public void save(Funcionario funcionario) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(funcionario);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
	}
	
	public Funcionario update(Funcionario funcionario) {
		try {
			entityManager.getTransaction().begin();
			Funcionario result = entityManager.merge(funcionario);
            entityManager.getTransaction().commit();
            return result;
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
		return null;
	}
	
	public void delete(Funcionario funcionario) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(funcionario);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
	}
	
	public Funcionario findById(Long id) {
		try {
			entityManager.getTransaction().begin();
			Funcionario result = entityManager.find(Funcionario.class, id);
            entityManager.getTransaction().commit();
            return result;
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
		return null;
	}
	
}
