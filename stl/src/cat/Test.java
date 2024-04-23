package cat;

public class Test
{
    public static void main(String[] args) {

        Color<? extends Object>color = new Color<Num>();

        Method method = new Method();

        method.set(color,"red");
    }
}
