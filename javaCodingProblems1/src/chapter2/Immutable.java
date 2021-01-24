package chapter2;

import java.util.ArrayList;
import java.util.List;

public final class Immutable {

    private final int x, y, z;
    private final List<String> list;

    private Immutable(int x1, int y1, int z1) {
        this(x1, y1, z1, null);
    }

    private Immutable(int x1, int y1, int z1, List<String> list1) {
        this.x = x1;
        this.y = y1;
        this.z = z1;

        this.list = new ArrayList<String>();
        if (list1!=null) {
            for (String s:list1) {
                list.add(s);
            }
        }
    }

    public static ImmutableBuilder getBuilder(int x, int y, int z) {
        return new ImmutableBuilder(x, y, z);
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

    public static final class ImmutableBuilder {

        private final int x, y, z;
        private List<String> list;

        public ImmutableBuilder(int x1, int y1, int z1) {
            x = x1;
            y = y1;
            z = z1;
        }

        public ImmutableBuilder list(List<String> pList) {
            this.list = pList;
            return this;
        }

        public Immutable build() throws IllegalArgumentException {
            if (this.x<0) {
                throw new IllegalArgumentException("x<0");
            }
            if (this.y<0) {
                throw new IllegalArgumentException("y<0");
            }
            if (this.z<0) {
                throw new IllegalArgumentException("z<0");
            }
            Immutable ret = new Immutable(this.x, this.y, this.z, this.list);
            return ret;
        }
    }
}
