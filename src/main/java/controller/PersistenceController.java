package controller;

import model.Vehicle;
import repository.VehicleRepository;

import java.util.List;

public class PersistenceController {

    VehicleRepository repository = new VehicleRepository();

    public void save(Vehicle vehicle) {
        repository.add(vehicle);
    }

    public void closeConnection() {
        repository.close();
    }

    public Boolean existLicensePlate(String licensePlate) {
        return repository.existLicensePlate(licensePlate);
    }

    public List<Vehicle> findAllVehicle() {
        return repository.findAll();
    }

    public Vehicle findVehicleById(Long id) {
        return repository.findById(id);
    }

    public void deleteVehicleById(Long id) {
        repository.delete(id);
    }

    public void updateVehicle(Vehicle vehicle) {
        repository.update(vehicle);
    }
}
