package com.ticket;

public class Run {
    public static void main(String[] args) {
        TicketSystem ticketSystem = new TicketSystem();
        Windows w1 = new Windows(ticketSystem);
        Windows w2 = new Windows(ticketSystem);
        new Thread(w1).start();
        new Thread(w2).start();
    }
}
