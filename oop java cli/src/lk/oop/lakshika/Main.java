package lk.oop.lakshika;// /src/Main.java
import java.util.Scanner;

public class Main {
    private static final String CONFIG_FILE = "config.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Configuration config = null;

        // Load existing configuration if available
        config = Configuration.loadFromFile(CONFIG_FILE);
        if (config == null) {
            config = new Configuration(100, 1000, 1500, 200); // Default values
            System.out.println("No existing configuration found. Using default values.");
        }

        // Collect user input
        config = configureSystem(scanner, config);

        // Save configuration
        config.saveToFile(CONFIG_FILE);
        System.out.println("Configuration saved.");

        // Start the system
        SystemController controller = new SystemController(config);
        controller.start();
    }

    private static Configuration configureSystem(Scanner scanner, Configuration config) {
        System.out.println("System Configuration:");

        config.setTotalTickets(promptForPositiveInt(scanner, "Total Tickets", config.getTotalTickets()));
        config.setTicketReleaseRate(promptForPositiveInt(scanner, "Ticket Release Rate (ms)", config.getTicketReleaseRate()));
        config.setCustomerRetrievalRate(promptForPositiveInt(scanner, "Customer Retrieval Rate (ms)", config.getCustomerRetrievalRate()));
        config.setMaxTicketCapacity(promptForPositiveInt(scanner, "Max Ticket Capacity", config.getMaxTicketCapacity()));

        return config;
    }

    private static int promptForPositiveInt(Scanner scanner, String prompt, int defaultValue) {
        int value;
        while (true) {
            System.out.printf("%s [%d]: ", prompt, defaultValue);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                value = defaultValue;
                break;
            }
            try {
                value = Integer.parseInt(input);
                if (value > 0) break;
                else System.out.println("Please enter a positive integer.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a positive integer.");
            }
        }
        return value;
    }
}
