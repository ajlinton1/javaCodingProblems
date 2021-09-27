package reflection;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@MyAnnotation
public class Melon<E extends Exception> extends Fruit<String, Seed> implements Comparator<Melon> {

    int weight;
    String melonType;
    private List<Slice> slices;
    public List<Slice> slice() throws E {
        return null;
    }

    public Map<String, Integer> asMap(List<Melon> melons) {
        return null;
    }

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

    public void peel(Slice slice) {
        System.out.println("The peel() method was invoked ...");
    }

}

