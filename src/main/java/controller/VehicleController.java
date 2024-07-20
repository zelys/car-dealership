package controller;

import model.Vehicle;
import model.VehicleMake;
import model.VehicleType;

import java.time.LocalDate;
import java.util.List;

public class VehicleController {

    public static PersistenceController persistence = new PersistenceController();

    public void save(String make, String type, String doors, String model, String engine, String color, String licensePlate) {
        Vehicle vehicle = new Vehicle();
        setVehicle(vehicle, make, type, doors, model, engine, color, licensePlate);

        persistence.save(vehicle);
    }

    public Boolean existLicensePlate(String licensePlate) {
        return persistence.existLicensePlate(licensePlate);
    }

    public List<Vehicle> findAllVehicle() {
        return persistence.findAllVehicle();
    }

    public void updateVehicle(Vehicle vehicle, String make, String type, String doors, String model, String engine, String color, String licensePlate) {
        setVehicle(vehicle, make, type, doors, model, engine, color, licensePlate);
        persistence.updateVehicle(vehicle);
    }

    public Vehicle findVehicleById(Long id) {
        return persistence.findVehicleById(id);
    }

    public void deleteVehicleById(Long id) {
        persistence.deleteVehicleById(id);
    }

    public static void closeConnection() {
        persistence.closeConnection();
    }

    private void setVehicle(Vehicle vehicle, String make, String type, String doors, String model, String engine, String color, String licensePlate) {
        vehicle.setMake(VehicleMake.valueOf(make));
        vehicle.setType(VehicleType.valueOf(type));
        vehicle.setDoorCount(doors);
        vehicle.setModel(model);
        vehicle.setEngine(engine);
        vehicle.setColor(color);
        vehicle.setLicensePlate(licensePlate);
        vehicle.setModified(LocalDate.now());
    }
}
