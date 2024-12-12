package lk.oop.lakshika;

// /src/SystemController.java
import java.util.ArrayList;
import java.util.List;

public class SystemController {
    private final Configuration config;
    private final TicketPool ticketPool;
    private final List<Thread> vendors;
    private final List<Thread> customers;

    public SystemController(Configuration config) {
        this.config = config;
        this.ticketPool = new TicketPool(config.getMaxTicketCapacity());
        this.vendors = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void start() {
        // Start vendors
        for (int i = 0; i < config.getTotalTickets(); i++) {
            Vendor vendor = new Vendor(i, ticketPool, config.getTicketReleaseRate());
            Thread vendorThread = new Thread(vendor);
            vendors.add(vendorThread);
            vendorThread.start();
        }

        // Start customers
        for (int i = 0; i < config.getTotalTickets(); i++) {
            Customer customer = new Customer(i, ticketPool, config.getCustomerRetrievalRate());
            Thread customerThread = new Thread(customer);
            customers.add(customerThread);
            customerThread.start();
        }

        System.out.println("System started. Press ENTER to stop...");
        try {
            System.in.read();
        } catch (Exception e) {
            // Ignored
        }

        stop();
    }

    public void stop() {
        vendors.forEach(Thread::interrupt);
        customers.forEach(Thread::interrupt);
        System.out.println("System stopped.");
    }
}
