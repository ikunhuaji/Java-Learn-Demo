package com.ticket;

public class Windows implements Runnable {
    TicketSystem ticketSystem;
    public Windows(TicketSystem ticketSystem){
        this.ticketSystem = ticketSystem;
    }
    @Override
    public void run() {
        while(true) {
            ticketSystem.sellTicket();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
