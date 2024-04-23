package File4;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class Test
{
    public static void main(String[] args) {
        try
        {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("E:\\32\\a.txt"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
