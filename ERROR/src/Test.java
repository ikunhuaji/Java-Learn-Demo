import java.nio.file.FileAlreadyExistsException;

public class Test
{
    public static class Info
    {
        public void show() throws ArrayIndexOutOfBoundsException,FileAlreadyExistsException
        {
            int[] num = {1,4};
            num[2]++;
        }
    }

    public static void main(String[] args) {
        Info info = new Info();

        try{
            info.show();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组越界");
            throw e;
        } catch (FileAlreadyExistsException e)
        {
            e.printStackTrace();
        } finally {
            System.out.println("结束");
        }
    }
}

//    public static double div(double x, double y) {
//        double d=0.0;
//        try {
//            d=x/y;
//            System.out.println(d);
//        }catch (Exception e)
//        {
//            e.printStackTrace();
//            System.out.println("异常");
//            System.exit(0);
//        }finally {
//            System.out.println("finally");
//        }
//
//        return d;
//    }
//
//    public static void main(String[] args) {
//        double s = div(10, 0);
//    }