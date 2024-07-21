import config.JPAConfig;
import controller.VehicleController;
import jakarta.persistence.EntityManagerFactory;
import repository.VehicleRepository;
import service.VehicleService;
import ui.utility.AppUIMediator;
import ui.utility.UIMediator;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        // Obtener el EntityManagerFactory
        EntityManagerFactory emf = JPAConfig.getEntityManagerFactory();
        // Inicializar el repositorio con el EntityManagerFactory
        VehicleRepository repository = new VehicleRepository(emf);
        // Inicializar el servicio con el repositorio
        VehicleService service = new VehicleService(repository);
        // Inicializar el controlador con el servicio
        VehicleController controller = new VehicleController(service);
        UIMediator mediator = new AppUIMediator(controller);
        SwingUtilities.invokeLater(mediator::showMainForm);
        // shutdown hook para cerrar el EntityManagerFactory
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (emf != null && emf.isOpen()) {
                emf.close();
            }
        }));
    }
}
