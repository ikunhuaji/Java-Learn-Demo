package D2024_03_05.TICKET;

import D2024_03_05.TICKET.TicketSystem;

public class Windows implements Runnable{

    TicketSystem ticketSystem;

    public Windows(TicketSystem ticketSystem){
        this.ticketSystem=ticketSystem;
    }

    @Override
    public void run() {
        while(true) {
            boolean fg=ticketSystem.sellTicket();
            if(fg){
                try {
                    Thread.sleep((int)(Math.random()*2000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                return;
            }
        }
    }
}
