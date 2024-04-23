package pack1;

public class Main {
    public static void main(String[] args) {
        System.out.println(DAY.Week.MONDAY.name());//返回MONDAY的类名
        System.out.println(DAY.Week.MONDAY.ordinal());//返回MONDAY的下标
        System.out.println(DAY.Week.MONDAY._day);
        System.out.println(DAY.Week.MONDAY._num);
    }
}