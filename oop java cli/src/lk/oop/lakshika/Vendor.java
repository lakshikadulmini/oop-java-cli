package lk.oop.lakshika;

// /src/Vendor.java
public class Vendor implements Runnable {
    private final int id;
    private final TicketPool ticketPool;
    private final int releaseInterval;

    public Vendor(int id, TicketPool ticketPool, int releaseInterval) {
        this.id = id;
        this.ticketPool = ticketPool;
        this.releaseInterval = releaseInterval;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            ticketPool.addTicket((int) (Math.random() * 1000));
            try {
                Thread.sleep(releaseInterval);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}


