package URL;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class Test {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.hebtu.edu.cn");

            URLConnection con = url.openConnection();

            InputStream is = con.getInputStream();

            OutputStream os = new FileOutputStream("E:\\hebtu.png");

            byte[] buffer = new byte[2048];
            int length = 0;

            while(-1!=(length = is.read(buffer,0,buffer.length)))
            {
                os.write(buffer,0,length);
            }
            is.close();
            os.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
