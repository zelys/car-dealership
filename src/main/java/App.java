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
        EntityManagerFactory emf = JPAConfig.getEntityManagerFactory();
        VehicleRepository repository = new VehicleRepository(emf);
        VehicleService service = new VehicleService(repository);
        VehicleController controller = new VehicleController(service);
        UIMediator mediator = new AppUIMediator(controller);
        SwingUtilities.invokeLater(mediator::showMainForm);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (emf != null && emf.isOpen()) {
                emf.close();
            }
        }));
    }
}
