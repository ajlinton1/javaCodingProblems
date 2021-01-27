package chapter2;

public class ClonableClass implements Cloneable{

    private final int x;
    private final Child child;

    public ClonableClass(int pX, String name) {
        x = pX;
        child = new Child(name);
    }

    public int getX() {
        return x;
    }

    public ClonableClass clone() throws CloneNotSupportedException {
        return (ClonableClass) super.clone();
    }
}
