package lk.oop.lakshika;
// /src/Configuration.java
import java.io.*;

public class Configuration {
    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity;

    public Configuration(int totalTickets, int ticketReleaseRate, int customerRetrievalRate, int maxTicketCapacity) {
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.customerRetrievalRate = customerRetrievalRate;
        this.maxTicketCapacity = maxTicketCapacity;
    }

    // Getters and Setters
    public int getTotalTickets() {return totalTickets; }
    public void setTotalTickets(int totalTickets) {this.totalTickets = totalTickets; }
    public int getTicketReleaseRate() { return ticketReleaseRate; }
    public void setTicketReleaseRate(int ticketReleaseRate) { this.ticketReleaseRate = ticketReleaseRate; }
    public int getCustomerRetrievalRate() { return customerRetrievalRate; }
    public void setCustomerRetrievalRate(int customerRetrievalRate) { this.customerRetrievalRate = customerRetrievalRate; }
    public int getMaxTicketCapacity() { return maxTicketCapacity; }
    public void setMaxTicketCapacity(int maxTicketCapacity) { this.maxTicketCapacity = maxTicketCapacity; }

    // Serialize and save to a text file
    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("totalTickets=" + totalTickets + "\n");
            writer.write("ticketReleaseRate=" + ticketReleaseRate + "\n");
            writer.write("customerRetrievalRate=" + customerRetrievalRate + "\n");
            writer.write("maxTicketCapacity=" + maxTicketCapacity + "\n");
        } catch (IOException e) {
            System.out.println("Error saving configuration: " + e.getMessage());
        }
    }

    // Deserialize and load from a text file
    public static Configuration loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int totalTickets = 100; // Default values
            int ticketReleaseRate = 1000;
            int customerRetrievalRate = 1500;
            int maxTicketCapacity = 200;

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    switch (parts[0]) {
                        case "totalTickets":
                            totalTickets = Integer.parseInt(parts[1]);
                            break;
                        case "ticketReleaseRate":
                            ticketReleaseRate = Integer.parseInt(parts[1]);
                            break;
                        case "customerRetrievalRate":
                            customerRetrievalRate = Integer.parseInt(parts[1]);
                            break;
                        case "maxTicketCapacity":
                            maxTicketCapacity = Integer.parseInt(parts[1]);
                            break;
                    }
                }
            }
            return new Configuration(totalTickets, ticketReleaseRate, customerRetrievalRate, maxTicketCapacity);
        } catch (IOException e) {
            System.out.println("Error loading configuration: " + e.getMessage());
            return null;
        } catch (NumberFormatException e) {
            System.out.println("Error parsing configuration file: " + e.getMessage());
            return null;
        }
    }
}
