package pack2;

interface anonymous{
    void display();
}

public class NoclassName {
    public void print(){
        anonymous anon = new anonymous() {//匿名内部类为实现方法的无名类
            @Override
            public void display() {
                System.out.println("implement anonymous");
            }
        };

        anon.display();
    }

}
