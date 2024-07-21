package service;

import model.Vehicle;
import repository.VehicleRepository;

import java.util.List;

public class VehicleService {
    private VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public void createVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    public Vehicle getVehicle(Long id) {
        return vehicleRepository.findById(id);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public void updateVehicle(Vehicle vehicle) {
        vehicleRepository.update(vehicle);
    }

    public void deleteVehicle(Vehicle vehicle) {
        vehicleRepository.delete(vehicle);
    }
}
