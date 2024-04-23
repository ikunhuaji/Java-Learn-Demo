package D2024_02_27.CLOCK;

import javax.swing.*;
import java.util.Date;

public class Clock extends JFrame implements Runnable {
    JTextField txt = new JTextField();

    @Override
    public void run() {
        while(true)
        {
            txt.setText(new Date().toLocaleString());
            try{
                Thread.sleep((1000));
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }

    public Clock()
    {
        this.getContentPane().add(txt);
        this.setVisible(true);
        this.setSize(100,20);
    }
}
