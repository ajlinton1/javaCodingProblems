package chapter2;

public final class Immutable {

    private final int x, y, z;

    public Immutable(int x1, int y1, int z1) {
        this.x = x1;
        this.y = y1;
        this.z = z1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
