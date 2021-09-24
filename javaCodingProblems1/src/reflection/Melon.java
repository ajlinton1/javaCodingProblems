package reflection;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@MyAnnotation
public class Melon implements Comparator<Melon> {

    int weight;
    String melonType;

    public Melon() {}

    public Melon(String melonType, int weight) {
        this.melonType = melonType;
        this.weight = weight;
    }

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

    public List<Melon> cultivate(
            String type, Seed seed, int noOfSeeds) {

        System.out.println("The cultivate() method was invoked ...");

        return Collections.nCopies(noOfSeeds, new Melon("Gac", 5));
    }

    public static void cultivate(Seed seeds) {
        System.out.println("The cultivate() method was invoked ...");
    }

    public static void peel(Slice slice) {
        System.out.println("The peel() method was invoked ...");
    }

}

