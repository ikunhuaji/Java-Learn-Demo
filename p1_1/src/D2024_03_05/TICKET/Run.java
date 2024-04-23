package D2024_03_05.TICKET;

public class Run {
    public static void main(String[] args) {
        TicketSystem ticketSystem = new TicketSystem(10);

        Windows windows=new Windows(ticketSystem);
        new Thread(windows).start();
    }
}
