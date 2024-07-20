package error;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ErrorHandler {
    private static final String LOG_FILE = "vehicle_repository.log";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void logError(String message, Exception e) {
        String timestamp = LocalDateTime.now().format(formatter);
        String logMessage = String.format("[%s] ERROR: %s%n", timestamp, message);

        try (FileWriter fw = new FileWriter(LOG_FILE, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(logMessage);
            e.printStackTrace(pw);
            pw.println(); // Add a blank line for readability
        } catch (IOException ioException) {
            System.err.println("Failed to write to log file: " + ioException.getMessage());
            ioException.printStackTrace();
        }

        // También imprimimos en la consola para debug inmediato
        System.err.println(logMessage);
        e.printStackTrace();
    }

    public static void logInfo(String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        String logMessage = String.format("[%s] INFO: %s%n", timestamp, message);

        try (FileWriter fw = new FileWriter(LOG_FILE, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(logMessage);
        } catch (IOException e) {
            System.err.println("Failed to write to log file: " + e.getMessage());
            e.printStackTrace();
        }

        // También imprimimos en la consola
        System.out.println(logMessage);
    }
}
