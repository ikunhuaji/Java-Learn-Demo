public class Main {
    public static void main(String[] args) {

        //String
        String s1 = ""+123;
        String s2 = new String(""+123);

        System.out.println(s1 == s2);//会判断地址
        System.out.println(s1.equals(s2));//只比较值的byte

        String email = "emain@qq.com@ssom";

        System.out.println(email.indexOf("@s"));
        System.out.println(email.lastIndexOf("om"));
        System.out.println(email.charAt(2));

        //StringBuffer
        StringBuffer stringBuffer = new StringBuffer("abc");
        stringBuffer.append("def");
        System.out.println(stringBuffer.toString());

        stringBuffer.insert(3,"ss");
        System.out.println(stringBuffer.toString());

        stringBuffer.delete(3,4);//删除3位置
        System.out.println(stringBuffer.toString());

        stringBuffer.reverse();//逆序
        System.out.println(stringBuffer.toString());

        //StringBuilder 在多线程中可能出错


    }
}