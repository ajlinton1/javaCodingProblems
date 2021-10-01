package functional;

import org.junit.Assert;
import org.junit.Test;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119619130/c06.xhtml#c6_1

public class TestFunctionalInterface {

    @Test
    public void testFunctionalInterface() {
        // list of animals
        List<Animal> animals = new ArrayList<Animal>();
        animals.add(new Animal("fish", false, true));
        animals.add(new Animal("kangaroo", true, false));
        animals.add(new Animal("rabbit", true, false));
        animals.add(new Animal("turtle", false, true));

        // pass class that does check
        print(animals, a -> a.canHop());
    }

    private static void print(List<Animal> animals, CheckTrait checker) {
        for (Animal animal : animals) {
            // the general check
            if (checker.test(animal))
                System.out.print(animal + " ");
            }
        System.out.println();
        }
}
