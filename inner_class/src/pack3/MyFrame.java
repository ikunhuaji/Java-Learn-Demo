package pack3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;

public class MyFrame extends JFrame{
    public boolean drawed = false;

    public int x,y;
    public MyFrame()
    {
        Container contentPane = this.getContentPane();

        MyMouseListener myMouseListener = new MyMouseListener(this);
        contentPane.addMouseListener(myMouseListener);

        contentPane.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
                Container panel = MyFrame.this.getContentPane();
                Graphics g = panel.getGraphics();//画笔
                x=e.getX();
                y=e.getY();
//                g.drawLine(x,y,e.getX(),e.getY());
//                g.drawRect(e.getX(),e.getY(),10,10);
                Random random = new Random();
                Color color = new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
                g.setColor(color);
                g.fillRect(e.getX(),e.getY(),10,10);
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });//通过匿名内部类直接实现 MouseMotionListener类,鼠标动作监听

        this.setSize(500,500);
        this.setVisible(true);
    }


}

