package Generic_Method_Class_Interface;

public class Method {
    static class Fruit{
        @Override
        public String toString() {
            return "fruit";
        }
    }
    static class Apple extends Fruit{
        @Override
        public String toString() {
            return "apple";
        }
    }
    static class Person{
        @Override
        public String toString() {
            return "person";
        }
    }
    static class GeneratedTest<T>{
        public void show_1(T t){
            System.out.println(t.toString());
        }
        public <E> void show_2(E t)
        {
            System.out.println(t.toString());
        }
        public <T> void show_3(T t){//此处T不再为泛型类的T，而是泛型方法的T
            System.out.println(t.toString());
        }
    }

    public static void main(String[] args) {
        Apple apple = new Apple();
        Person person = new Person();

        GeneratedTest<Fruit>generatedTest = new GeneratedTest<>();
        generatedTest.show_1(apple);
//        generatedTest.show_1(person); 报错参数类型不对

        generatedTest.show_2(apple);
        generatedTest.show_2(person);

        generatedTest.show_3(apple);
        generatedTest.show_3(person);
    }
}
