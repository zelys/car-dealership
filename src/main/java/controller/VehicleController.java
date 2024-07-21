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

    public void createVehicle(String brand, String model, String engine, String type, String color ,String doorCount, String licensePlate) {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(brand);
        vehicle.setModel(model);
        vehicle.setEngine(engine);
        vehicle.setType(type);
        vehicle.setColor(color);
        vehicle.setDoorCount(doorCount);
        vehicle.setLicensePlate(licensePlate);
        vehicleService.createVehicle(vehicle);
    }

    public Vehicle getVehicle(Long id) {
        return vehicleService.getVehicle(id);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    public void updateVehicle(Vehicle vehicle, String brand, String model, String engine, String type, String color ,String doorCount, String licensePlate) {
        if (vehicle != null) {
            vehicle.setBrand(brand);
            vehicle.setModel(model);
            vehicle.setLicensePlate(licensePlate);
            vehicle.setType(type);
            vehicle.setColor(color);
            vehicle.setDoorCount(doorCount);
            vehicle.setEngine(engine);
            vehicle.setModified(LocalDate.now());
            vehicleService.updateVehicle(vehicle);
        }
    }

    public void deleteVehicle(Long id) {
        Vehicle vehicle = vehicleService.getVehicle(id);
        if (vehicle != null) {
            vehicleService.deleteVehicle(vehicle);
        }
    }


    public boolean hasPlatesDuplicated(String licensePlate, List<Vehicle> allVehicles) {
        return allVehicles.stream()
                .anyMatch(v -> v.getLicensePlate().equals(licensePlate));
    }
}