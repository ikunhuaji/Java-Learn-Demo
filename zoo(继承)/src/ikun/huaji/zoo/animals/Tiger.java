package ikun.huaji.zoo.animals;

public class Tiger extends Animal
{
    public Tiger(String name)
    {
//        super();
//        super可调用父类函数与非私有属性
        this();
        System.out.println("子类有参构造");
    }

    public Tiger()//无参构造，在新建子类Tiger时调用,且在没用super调用父类构造时，会先调用父类无参构造
    {
//        super("son");//调用父类单参构造
        System.out.println("son" + " " + "构造");
    }
    public void display()//override重写父类函数，不能重写final和private函数
    {
        System.out.println("son display");
    }
}
