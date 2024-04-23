public class Main
{
    public static void main(String[] args)
    {
        Integer count1 = Integer.valueOf(128);
        Integer count2 = Integer.valueOf(128);

        System.out.println(count1==count2);
        System.out.println(count1.equals(count2));

        count2--;
        count1--;

        System.out.println(count1==count2);
        System.out.println(count1.equals(count2));
    }
}