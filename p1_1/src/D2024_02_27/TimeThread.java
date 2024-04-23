package D2024_02_27;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeThread extends Thread{
    @Override
    public void run() {

        for(int i=1;i<=10;i++)
        {
            Date data = new Date();
            //DateFormat df1 = DateFormat.getDateInstance(DateFormat.FULL);

            //String tmp = df1.format(data);

            System.out.println(data);
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }

        }

        System.out.println("END");
    }
}
