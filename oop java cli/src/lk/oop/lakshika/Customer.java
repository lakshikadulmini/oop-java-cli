package lk.oop.lakshika;

public class Customer implements Runnable {
    private final int id;
    private final TicketPool ticketPool;
    private final int retrievalInterval;

    public Customer(int id, TicketPool ticketPool, int retrievalInterval) {
        this.id = id;
        this.ticketPool = ticketPool;
        this.retrievalInterval = retrievalInterval;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            ticketPool.removeTicket();
            try {
                Thread.sleep(retrievalInterval);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
