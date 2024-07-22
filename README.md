# App de escritorio para Automotora

Una concecionaria de vehículos necesita de un sistema que le permita realizar un CRUD de todos los vehículos que tiene actualmente a la venta para luego publicarlos en un catálogo.
Se requiere realizar un modelado correspondiente vehículo teniendo en cuenta campos como: id, modelo, marca, motor, color, patente, cantidad de puertas. 
La app debe para permitir realizar las operaciones CRUD para cada vehículo.

**IMPORTANTE**: Este proyecto fue desarrollado respetando el modelo de capas, separando la responsabilidad de cada una de ellas: lógica, interfaz gráfica y persistencia.

## Tecnologías

- Java JDK 17
- Java JPA
- MySQL
- Maven

## Dependencias

- MySQL Driver
- EclipseLink
- Lombok

[![Finalizado - Sin Desplegar](https://img.shields.io/badge/Estado-Finalizado%20|%20Sin%20Desplegar-blue?style=for-the-badge&logo=github&logoColor=white)](https://github.com/tu-usuario/tu-repositorio)

## Registros para interactuar con la base de datos

- Tabla vehicles:
```sql
INSERT INTO vehicles (BRAND, MODEL, ENGINE, COLOR, LICENSE_PLATE, TYPE, DOOR_COUNT, MODIFIED, CREATED)
VALUES
    ('TOYOTA', 'Corolla', '1.8L I4', 'Rojo', 'ABCD12', 'COMPACT', '4', '2024-05-15', '2024-01-10'),
    ('HONDA', 'Civic', '2.0L I4', 'Azul', 'EFGH34', 'COMPACT', '4', '2024-06-20', '2024-02-05'),
    ('FORD', 'Mustang', '5.0L V8', 'Negro', 'IJKL56', 'MUSCLE_CAR', '2', '2024-07-01', '2024-03-15'),
    ('CHEVROLET', 'Silverado', '5.3L V8', 'Blanco', 'MNOP78', 'PICKUP', '4', '2024-05-30', '2024-01-20'),
    ('VOLKSWAGEN', 'Golf', '1.4L I4', 'Gris', 'QRST90', 'COMPACT', '4', '2024-06-10', '2024-02-28'),
    ('BMW', 'X5', '3.0L I6', 'Negro', 'UVWX12', 'LUXURY', '5', '2024-07-05', '2024-03-01'),
    ('MERCEDES_BENZ', 'C-Class', '2.0L I4', 'Plata', 'YZAB34', 'LUXURY', '4', '2024-05-25', '2024-01-15'),
    ('AUDI', 'A4', '2.0L I4', 'Blanco', 'CDEF56', 'LUXURY', '4', '2024-06-15', '2024-02-10'),
    ('NISSAN', 'Altima', '2.5L I4', 'Azul', 'GHIJ78', 'COMPACT', '4', '2024-07-10', '2024-03-20'),
    ('HYUNDAI', 'Tucson', '2.5L I4', 'Verde', 'KLMN90', 'CROSSOVER', '5', '2024-05-20', '2024-01-25'),
    ('KIA', 'Sportage', '2.4L I4', 'Naranja', 'OPQR12', 'CROSSOVER', '5', '2024-06-25', '2024-02-15'),
    ('SUBARU', 'Outback', '2.5L H4', 'Marrón', 'STUV34', 'WAGON', '5', '2024-07-15', '2024-03-05'),
    ('MAZDA', 'CX-5', '2.5L I4', 'Rojo', 'WXYZ56', 'CROSSOVER', '5', '2024-05-10', '2024-01-30'),
    ('LEXUS', 'RX', '3.5L V6', 'Gris', 'BCDE78', 'LUXURY', '5', '2024-06-30', '2024-02-20'),
    ('JEEP', 'Wrangler', '3.6L V6', 'Verde', 'FGHI90', 'OFF_ROAD', '2', '2024-07-20', '2024-03-10'),
    ('TOYOTA', 'Prius', '1.8L I4 Hybrid', 'Azul', 'JKLM12', 'HYBRID', '4', '2024-05-05', '2024-01-05'),
    ('HONDA', 'CR-V', '1.5L I4', 'Plata', 'NOPQ34', 'CROSSOVER', '5', '2024-06-05', '2024-02-25'),
    ('FORD', 'F-150', '3.5L V6', 'Negro', 'RSTU56', 'PICKUP', '4', '2024-07-25', '2024-03-25'),
    ('CHEVROLET', 'Camaro', '6.2L V8', 'Amarillo', 'VWXY78', 'SPORTS_CAR', '2', '2024-05-01', '2024-01-01'),
    ('VOLKSWAGEN', 'ID.4', 'Electric', 'Blanco', 'ZABC90', 'ELECTRIC', '5', '2024-06-01', '2024-02-01');
```