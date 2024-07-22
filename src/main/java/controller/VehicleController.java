package controller;


import model.Vehicle;
import service.VehicleService;

import java.time.LocalDate;
import java.util.List;

public class VehicleController {
    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    public void createVehicle(Vehicle vehicle) {
        vehicleService.createVehicle(vehicle);
    }

    public Vehicle getVehicle(Long id) {
        return vehicleService.getVehicle(id);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    public void updateVehicle(Vehicle vehicle) {
        vehicleService.updateVehicle(vehicle);
    }

    public void deleteVehicle(Long id) {
        Vehicle vehicle = vehicleService.getVehicle(id);
        if (vehicle != null) {
            vehicleService.deleteVehicle(vehicle);
        }
    }


    public boolean hasPlatesDuplicated(String licensePlate) {
        List<Vehicle> allVehicles = vehicleService.getAllVehicles();
        return allVehicles.stream()
                .anyMatch(v -> v.getLicensePlate().equals(licensePlate));
    }
}