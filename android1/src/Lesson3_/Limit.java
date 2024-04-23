package Lesson3_;

public class Limit<T> {
//    private T date;

//    限制1：不能实例化类型变量T
//    public Limit() {
//        this.date = new T();
//    }

//    限制2：静态域或者方法不能引用类型变量，执行顺序问题
//    private static T instance;

//    静态方法为泛型方法时可行
//    private static <T>T getInstancee(){}

//    public static void main(String[] args) {

//    限制3：类型变量应为包装器类型
//        Limit<double>limit1;  X
//        Limit<Double>limit1;  √

//    限制4：不能判定泛型类型
//    instanceof()    判定类型
//    if(limit1 instanceof Limit<Double>)
//    if(limit1 instanceof Limit<T>)

//    限制5：泛型类getClass返回类，判断不根据类型变量
//    Limit<Integer>limitInt = new Limit<>();
//    Limit<String>limitString = new Limit<>();
//    System.out.println(limitInt.getClass() == limitString.getClass());
//    返回True，返回值都为 Limit

//    限制6：可定义泛型数组，不能创建
//    Limit<Double>[] Arr1;   可声明
//    Limit<Double>[] Arr2 = new Limit<Double>[10];   报错

//    限制7：泛型类不能extends Exception
//    private class Problem<T> extends Exception{}    报错

//    限制8：不能捕获泛型类对象
//    public <T extends Throwable> void doWork(T x){
//        try{
//
//        }catch (T t){
//
//        }
//    }

//    }
}
