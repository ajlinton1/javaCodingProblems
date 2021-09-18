package reflection;

import java.util.Comparator;

public class Melon implements Comparator<Melon> {

    int weigth;

    public int getWeigth() {
        return weigth;
    }

    @Override
    public int compare(Melon m1, Melon m2) {
        return Integer.compare(m1.getWeigth(), m2.getWeigth());
    }

    public class Slice {

    }

    public void method1(String... args) {
        System.out.println(args);
        return;
    }

    public class NestedClasss {

        public String nestedMethod() {
            return "This is a test";
        }
    }
}
