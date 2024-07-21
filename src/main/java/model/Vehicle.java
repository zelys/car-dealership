package model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "licensePlate")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private VehicleBrand brand;

    @Column(length = 20)
    private String model;
    @Column(length = 20)
    private String engine;
    @Column(length = 20)
    private String color;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private VehicleType type;

    @Column(name = "LICENSE_PLATE", length = 6, unique = true)
    private String licensePlate;

    @Column(name = "DOOR_COUNT", length = 1)
    private Integer doorCount;

    private LocalDate created = LocalDate.now();
    private LocalDate modified = LocalDate.now();

    public void setDoorCount(String doorCount) {
        this.doorCount = Integer.parseInt(doorCount);
    }

    public void setType(String type) {
        this.type = VehicleType.valueOf(type);
    }

    public void setBrand(String brand) {
        this.brand = VehicleBrand.valueOf(brand);
    }

    @Override
    public String toString() {
        return "(ID: " + id +
                ", MARCA: " + brand +
                ", MODELO: '" + model + '\'' +
                ", MOTOR: '" + engine + '\'' +
                ", COLOR: '" + color + '\'' +
                ", TIPO: " + type +
                ", PATENTE: '" + licensePlate + '\'' +
                ", PUERTAS: " + doorCount +
                ", " + created + ')';
    }
}
