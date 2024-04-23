package com.ticket;

public class TicketSystem {
    private int count = 10;

    Object obj = new Object();
    public /*synchronized*/ void sellTicket(){
        synchronized (TicketSystem.class) {
            if (count > 0) {
                count--;
                System.out.println("还剩票：" + count);
            }
        }

    }
}
