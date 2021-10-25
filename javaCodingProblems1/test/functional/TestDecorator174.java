package functional;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.Consumer;

public class TestDecorator174 {

    @Test
    public void testDecorator() {

        Consumer<String> original = (String s) -> {
            System.out.println("Original: " + s);};

        original.accept("This is a test");

        var decorator = new Decorator(original);
        decorator.accept("Second test");
    }

    public class Decorator {

        Consumer<String> original;

        public Decorator(Consumer<String> original) {
            this.original = original;
        }

        public void accept(String s) {
            System.out.println("Before");
            original.accept(s);
            System.out.println("After");
        }


    }
}

