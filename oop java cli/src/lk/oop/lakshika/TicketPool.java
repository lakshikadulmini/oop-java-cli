package lk.oop.lakshika;

// /src/TicketPool.java
import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {
    private final Queue<Integer> tickets;
    private final int maxCapacity;

    public TicketPool(int maxCapacity) {
        this.tickets = new LinkedList<>();
        this.maxCapacity = maxCapacity;
    }

    public synchronized void addTicket(int ticketId) {
        while (tickets.size() >= maxCapacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        tickets.add(ticketId);
        System.out.println("Ticket added: " + ticketId);
        notifyAll();
    }

    public synchronized Integer removeTicket() {
        while (tickets.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        }
        Integer ticket = tickets.poll();
        System.out.println("Ticket removed: " + ticket);
        notifyAll();
        return ticket;
    }
}
