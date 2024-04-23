package File1;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Test {

    public static void Demo(File file) {//打印函数

        if(file.isFile())
        {
            System.out.println("文件名：" + file.getName());
        }
        else if(file.isDirectory())
        {
            System.out.println("目录：" + file.getName());
            File[] files = file.listFiles();
            for (File fl : files )
            {
                Demo(fl);
            }
        }
    }

    public static void main(String[] args) {

    //创建日期文件夹
        LocalDate now = LocalDate.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM");
        File dir = new File("E:\\"+now.format(df));

        boolean r = false;

        if(!dir.exists())
        {
            r=dir.mkdir();
            if(r) System.out.println("创建成功");
        }
        File file = new File(dir+"/"+now.format(df)+".txt");
        if(!file.exists())
        {
            try
            {
                r=file.createNewFile();
            }catch (Exception e)
            {
                e.printStackTrace();
            }
            if(r) System.out.println("txt创建成功");
        }

    //删除操作
        Scanner cin = new Scanner(System.in);
        if(cin.nextInt()==1)
        {
            try
            {
                r=dir.delete();
            }catch (Exception e)
            {
                e.printStackTrace();
            }
            if(r)
            {
                System.out.println("删除成功");
            }
        }

    //打印文件名和目录名
        file = new File("E:\\code");
        Demo(file);//使用Demo打印所有code的文件

    }
}
