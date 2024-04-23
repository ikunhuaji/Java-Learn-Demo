package D2024_03_05.TICKET;

public class TicketSystem {
    private int count ;

    public TicketSystem(int count)
    {
        this.count=count;
        System.out.println("票总数"+count);
    }

    public boolean sellTicket(){
        if(count>0)
        {
            System.out.println("卖出第 " + count+" 张票");
            count--;
            System.out.println("还剩票：" + count+" 张");
            return true;
        }
        else {
            System.out.println("售罄");
            return false;
        }
    }

}
