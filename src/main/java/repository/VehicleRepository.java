package repository;

import jakarta.persistence.*;
import model.Vehicle;

import java.util.List;

public class VehicleRepository {
    private final EntityManagerFactory emf;

    public VehicleRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void save(Vehicle vehicle) throws PersistenceException {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.persist(vehicle);
            tx.commit();
        } catch (PersistenceException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new PersistenceException("Error saving vehicle", e);
        } finally {
            em.close();
        }
    }

    public Vehicle findById(Long id) throws PersistenceException {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Vehicle.class, id);
        } catch (PersistenceException e) {
            throw new PersistenceException("Error finding vehicle with id: " + id, e);
        } finally {
            em.close();
        }
    }

    public List<Vehicle> findAll() throws PersistenceException {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Vehicle> query = em.createQuery("SELECT v FROM Vehicle v", Vehicle.class);
            return query.getResultList();
        } catch (PersistenceException e) {
            throw new PersistenceException("Error retrieving all vehicles", e);
        } finally {
            em.close();
        }
    }

    public void update(Vehicle vehicle) throws PersistenceException {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.merge(vehicle);
            tx.commit();
        } catch (PersistenceException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new PersistenceException("Error updating vehicle", e);
        } finally {
            em.close();
        }
    }

    public void delete(Vehicle vehicle) throws PersistenceException {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            vehicle = em.merge(vehicle);  // Reattach the entity if it's detached
            em.remove(vehicle);
            tx.commit();
        } catch (PersistenceException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new PersistenceException("Error deleting vehicle", e);
        } finally {
            em.close();
        }
    }
}