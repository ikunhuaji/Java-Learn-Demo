package File3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test
{

    public static void main(String[] args) {
        //对象流

        Message message = new Message();

        message.setContent("hello");
        message.setId(1);
        message.setReceiveId("It");
        message.setSendId("I");
        message.setState(8);

        try{

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("E:\\32/a.txt"));
            objectOutputStream.writeObject(message);

            objectOutputStream.flush();
            objectOutputStream.close();

            //反序列化
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("E:\\32/a.txt"));
            Object obj = objectInputStream.readObject();
            Message msg = (Message)(obj);

            System.out.println(msg);
            objectInputStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
