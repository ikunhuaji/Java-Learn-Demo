package cat;

public class Color <T>
{
    T color;

    public T getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = (T) color;
    }
}
