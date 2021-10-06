package functional;

import org.junit.Assert;
import org.junit.Test;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestLambda {

    @Test
    public void testLambda() {
        // list of animals
        List<Animal> animals = new ArrayList<Animal>();
        animals.add(new Animal("fish", false, true));
        animals.add(new Animal("kangaroo", true, false));
        animals.add(new Animal("rabbit", true, false));
        animals.add(new Animal("turtle", false, true));

        // pass class that does check
        print(animals, a -> a.canHop());

    }

    private static void print(List<Animal> animals, Predicate<Animal> checker) {
        for (Animal animal : animals) {
            // the general check
            if (checker.test(animal))
                System.out.print(animal + " ");
        }
        System.out.println();
    }

    @Test
    public void testConsumer() {
        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("This is a test");
    }

    @Test
    public void testSupplier() {
        Supplier<Integer> supplier = () -> new Random().nextInt();
        System.out.println(supplier.get());
    }

}
