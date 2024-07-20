package repository;

import error.ErrorHandler;
import jakarta.persistence.*;
import model.Vehicle;

import java.util.List;

public class VehicleRepository {

    private EntityManagerFactory emf;
    private EntityManager em;

    public VehicleRepository() {
        try {
            this.emf = Persistence.createEntityManagerFactory("dealershipPU");
            this.em = emf.createEntityManager();
            ErrorHandler.logInfo("VehicleRepository initialized successfully");
        } catch (Exception e) {
            ErrorHandler.logError("Error initializing VehicleRepository", e);
        }
    }

    // AGREGAR UN VEHÍCULO
    public void add(Vehicle vehicle) {
        try {
            em.getTransaction().begin();
            em.persist(vehicle);
            em.getTransaction().commit();
            ErrorHandler.logInfo("Vehicle added successfully: " + vehicle.toString());
        } catch (Exception e) {
            em.getTransaction().rollback();
            ErrorHandler.logError("Error adding vehicle: " + vehicle.toString(), e);
        }
    }

    // CONSULTAR TODOS LOS VEHÍCULOS
    public List<Vehicle> findAll() {
        try {
            TypedQuery<Vehicle> query = em.createQuery("SELECT v FROM Vehicle v", Vehicle.class);
            List<Vehicle> vehicles = query.getResultList();
            ErrorHandler.logInfo("Retrieved " + vehicles.size() + " vehicles");
            return vehicles;
        } catch (Exception e) {
            ErrorHandler.logError("Error retrieving all vehicles", e);
            return null;
        }
    }

    // CONSULTAR UN VEHÍCULO POR ID
    public Vehicle findById(Long id) {
        return em.find(Vehicle.class, id);
    }

    // ACTUALIZAR UN VEHÍCULO
    public void update(Vehicle vehicle) {
        try {
            em.getTransaction().begin();
            em.merge(vehicle);
            em.getTransaction().commit();
            ErrorHandler.logInfo("Vehicle successfully updated: " + vehicle.toString());
        } catch (Exception e) {
            em.getTransaction().rollback();
            ErrorHandler.logError("Error updating vehicle: " + vehicle.toString(), e);
        }
    }

    // ELIMINAR UN VEHÍCULO
    public void delete(Long id) {
        Vehicle vehicle = em.find(Vehicle.class, id);
        try {
            em.getTransaction().begin();
            em.remove(vehicle);
            em.getTransaction().commit();
            ErrorHandler.logInfo("Vehicle successfully removed: " + vehicle.toString());
        } catch (Exception e) {
            em.getTransaction().rollback();
            ErrorHandler.logError("Error deleting vehicle: " + vehicle.toString(), e);
        }
    }

    // VERIFICA SI YA EXISTE PLACA PATENTE EN LA BD
    public boolean existLicensePlate(String licensePlate) {
        Query query = em.createQuery("SELECT COUNT(v) FROM Vehicle v WHERE v.licensePlate = :licensePlate");
        query.setParameter("licensePlate", licensePlate);
        Long count = (Long) query.getSingleResult();
        return count > 0;
    }

    // CERRAR LAS CONEXIONES
    public void close() {
        try {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
            ErrorHandler.logInfo("VehicleRepository closed successfully");
        } catch (Exception e) {
            ErrorHandler.logError("Error closing VehicleRepository", e);
        }
    }
}
