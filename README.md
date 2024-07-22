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
INSERT INTO vehicles (brand, model, engine, color, License_plate, type, door_count, modifier, created)
VALUES
    ('TOYOTA', 'COROLLA', '1.8L I4', 'ROJO', 'ABCD12', 'COMPACT', '4', '2024-05-15', '2024-01-10'),
    ('HONDA', 'CIVIC', '2.0L I4', 'AZUL', 'EFGH34', 'COMPACT', '4', '2024-06-20', '2024-02-05'),
    ('FORD', 'MUSTANG', '5.0L V8', 'NEGRO', 'IJKL56', 'MUSCLE_CAR', '2', '2024-07-01', '2024-03-15'),
    ('CHEVROLET', 'SILVERADO', '5.3L V8', 'BLANCO', 'MNOP78', 'PICKUP', '4', '2024-05-30', '2024-01-20'),
    ('VOLKSWAGEN', 'GOLF', '1.4L I4', 'GRIS', 'QRST90', 'COMPACT', '4', '2024-06-10', '2024-02-28'),
    ('BMW', 'X5', '3.0L I6', 'NEGRO', 'UVWX12', 'LUXURY', '5', '2024-07-05', '2024-03-01'),
    ('MERCEDES_BENZ', 'C-CLASS', '2.0L I4', 'PLATA', 'YZAB34', 'LUXURY', '4', '2024-05-25', '2024-01-15'),
    ('AUDI', 'A4', '2.0L I4', 'BLANCO', 'CDEF56', 'LUXURY', '4', '2024-06-15', '2024-02-10'),
    ('NISSAN', 'ALTIMA', '2.5L I4', 'AZUL', 'GHIJ78', 'COMPACT', '4', '2024-07-10', '2024-03-20'),
    ('HYUNDAI', 'TUCSON', '2.5L I4', 'VERDE', 'KLMN90', 'CROSSOVER', '5', '2024-05-20', '2024-01-25'),
    ('KIA', 'SPORTAGE', '2.4L I4', 'NARANJA', 'OPQR12', 'CROSSOVER', '5', '2024-06-25', '2024-02-15'),
    ('SUBARU', 'OUTBACK', '2.5L H4', 'MARRÓN', 'STUV34', 'WAGON', '5', '2024-07-15', '2024-03-05'),
    ('MAZDA', 'CX-5', '2.5L I4', 'ROJO', 'WXYZ56', 'CROSSOVER', '5', '2024-05-10', '2024-01-30'),
    ('LEXUS', 'RX', '3.5L V6', 'GRIS', 'BCDE78', 'LUXURY', '5', '2024-06-30', '2024-02-20'),
    ('JEEP', 'WRANGLER', '3.6L V6', 'VERDE', 'FGHI90', 'OFF_ROAD', '2', '2024-07-20', '2024-03-10'),
    ('TOYOTA', 'PRIUS', '1.8L I4 HYBRID', 'AZUL', 'JKLM12', 'HYBRID', '4', '2024-05-05', '2024-01-05'),
    ('HONDA', 'CR-V', '1.5L I4', 'PLATA', 'NOPQ34', 'CROSSOVER', '5', '2024-06-05', '2024-02-25'),
    ('FORD', 'F-150', '3.5L V6', 'NEGRO', 'RSTU56', 'PICKUP', '4', '2024-07-25', '2024-03-25'),
    ('CHEVROLET', 'CAMARO', '6.2L V8', 'AMARILLO', 'VWXY78', 'SPORTS_CAR', '2', '2024-05-01', '2024-01-01'),
    ('VOLKSWAGEN', 'ID.4', 'ELECTRIC', 'BLANCO', 'ZABC90', 'ELECTRIC', '5', '2024-06-01', '2024-02-01');
```
## Screenshot
![main menu](https://i.imgur.com/nDlzGGu.png)

![vehicles list](https://i.imgur.com/I066ZWj.png)