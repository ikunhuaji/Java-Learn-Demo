package File1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class MyFrame extends JFrame
{
    public MyFrame()
    {
        File file = new File("E:\\FF");
    }

    public void rend(File file,MyFrame myFrame)
    {
        myFrame.getContentPane().removeAll();
        File[] files = file.listFiles();
        for(File tmp:files)
        {
            JButton btn = new JButton(tmp.getName());
            btn.addActionListener((new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(tmp.isDirectory())
                    {
                        rend(tmp,myFrame);
                    }
                }
            }));
            myFrame.getContentPane().add(btn);
        }
    }

    public static void main(String[] args) {

    }
}
