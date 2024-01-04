package vn.aptech.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import vn.aptech.entity.Account;

public class AccountDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("accountJpaPU");

	public List<Account> findAll() {
		List<Account> result = null;
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Query q = em.createQuery("SELECT o FROM Account o");
			result = q.getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return result;
	}

	public int login(String email, String password) {
		int result = 0;
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Query q = em.createQuery("SELECT o FROM Account o WHERE o.email=:email AND o.password=:password");
			// truyền giá trị cho tham số :email, :password
			q.setParameter("email", email);
			q.setParameter("password", password);

			if (q.getSingleResult() != null) {
				Account a = (Account) q.getSingleResult();
				result = a.getRole();
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return result;
	}

	public void create(Account acc) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(acc);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public Account findById(int id) {
		Account result = null;
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			result = em.find(Account.class, id);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return result;
	}

	public void update(Account acc) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(em.merge(acc));
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
}
