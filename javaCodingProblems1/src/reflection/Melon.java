package reflection;

import java.util.Comparator;

@MyAnnotation
public class Melon implements Comparator<Melon> {

    int weight;

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compare(Melon m1, Melon m2) {
        return Integer.compare(m1.getWeight(), m2.getWeight());
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
