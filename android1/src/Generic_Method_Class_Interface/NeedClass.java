package Generic_Method_Class_Interface;

public class NeedClass<T> {//泛型类
    private T date;
    public <E> E genericMethod(E...a){//泛型方法，前面 E 用于限定参数
        return a[a.length/2];
    }
    public NeedClass() {
    }

    public NeedClass(T date) {
        this.date = date;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    public static void main(String[] args) {
        NeedClass<String> needClass1 = new NeedClass<>();
        needClass1.setDate("A");
        System.out.println(needClass1.getDate());

        NeedClass<Integer> test = new NeedClass<>();
        System.out.println(test.<String>genericMethod("a", "b", "c", "d"));//限定为String
        System.out.println(test.genericMethod(1, 2, 3, 4));//可不限定，自适应类型

    }
}
