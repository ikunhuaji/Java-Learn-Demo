package ikun.huaji.zoo.animals;

public class Animal//final加在类前表示不可继承
{
    final String nn="op";//final加在变量，表示不能修改
    public Animal(String name)
    {
        System.out.println("father"+" "+"单参构造");
    }
    public Animal()//父类无参构造，在创建新父类对象或子类对象会调用
    {
        System.out.println("father"+" "+"构造");
    }
    public void display()
    {
        System.out.println("father display");
    }

    public final void keep()//final加在父类函数，表示不能被子类重写
    {
        System.out.println("father peep");
    }
}
