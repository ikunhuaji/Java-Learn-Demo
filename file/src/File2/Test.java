package File2;

import java.io.*;
import java.util.LinkedHashSet;

public class Test {

    //文件分割
    public static void splitFile(){

        try {
            FileInputStream fis = new FileInputStream("D://新建文件夹//html//imgs//o神.png");
            byte[] cache = new byte[fis.available()];
            fis.read(cache);
            FileOutputStream fos1 = new FileOutputStream("D://新建文件夹//html//imgs//new1.png");
            FileOutputStream fos2 = new FileOutputStream("D://新建文件夹//html//imgs//new2.png");

            fos1.write(cache,0, cache.length/3);
            fos2.write(cache,cache.length/3,cache.length-cache.length/3);
            fos1.flush();
            fos2.flush();
            fis.close();
            fos1.close();
            fos2.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            System.out.println("结束");
        }

    }

    public static void main(String[] args) {

        splitFile();

//        字符流 输入 Reader 输出 Writer
        try
        {
            LinkedHashSet<String>set = new LinkedHashSet<>();
            FileReader fr = new FileReader("D://新建文件夹//html//imgs//new.txt");//字符流
            BufferedReader br = new BufferedReader(fr);//行的字符流

            String line = br.readLine();

            while(line!=null)
            {
                System.out.println(line);
                String[] split = line.split(" ");
                for(String s:split)
                {
                    set.add(s);
                }
                line=br.readLine();
            }
            br.close();
            fr.close();

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D://新建文件夹//html//imgs//set.txt"));

            for (String s:set)
            {
                bufferedWriter.write(s);
                bufferedWriter.write(" ");
            }

            bufferedWriter.flush();
            bufferedWriter.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        //字节流 输入 InputStream 输出 OutputStream

        File file = new File("D://新建文件夹//html//imgs//o神.png");

            //文件复制操作
        try{
            //构造流
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream("D://新建文件夹//html//imgs//new.png");

            //读数据
            byte[] cache = new byte[fis.available()];
            fis.read(cache);

            //处理

            //关闭流
            fis.close();
            fos.write(cache);
            fos.flush();
            fos.close();

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (Exception e)
        {
            e.printStackTrace();
        }





    }
}
