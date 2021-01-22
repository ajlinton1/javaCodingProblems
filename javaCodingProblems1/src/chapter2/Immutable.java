package chapter2;

import java.util.ArrayList;
import java.util.List;

public final class Immutable {

    private final int x, y, z;
    private final List<String> list;

    public Immutable(int x1, int y1, int z1) {
        this(x1, y1, z1, null);
    }

    public Immutable(int x1, int y1, int z1, List<String> list1) {
        this.x = x1;
        this.y = y1;
        this.z = z1;

        this.list = new ArrayList<String>();
        for (String s:list1) {
            list.add(s);
        }
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

    public List<String> getList() {
        List<String> list1 = new ArrayList<String>();
        for (String s:list) {
            list1.add(s);
        }
        return list1;
    }
}
