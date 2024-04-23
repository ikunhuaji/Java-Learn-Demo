import java.util.StringTokenizer;

public class StringTest
{
    public static void main(String[] args) {

        //StringTokenizer
        String s = "abcdefghdijk";
        StringTokenizer stk = new StringTokenizer(s,"d");

        while(stk.hasMoreTokens())//是否有更多分隔符
        {
            String s1 = stk.nextToken();//返回下一个分隔符前的内容值
            System.out.println(s1);
        }


    }
}
