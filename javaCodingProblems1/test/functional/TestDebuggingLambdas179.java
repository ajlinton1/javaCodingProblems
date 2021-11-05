package functional;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestDebuggingLambdas179 {

    @Test
    public void testDebuggingLambda() {
        List<String> names = Arrays.asList("anna", "bob", null, "mary");

        names.stream()
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());
    }

    @Test
    public void testDebuggingLambda2() {
        List<String> list = List.of("anna", "bob",
                "christian", "carmen", "rick", "carla");

        list.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    public void testDebuggingLambda3() {
        List<String> list = List.of("anna", "bob",
                "christian", "carmen", "rick", "carla");

        list.stream()
                .peek(p -> System.out.println("\tstream(): " + p))
                .filter(s -> s.startsWith("c"))
                .peek(p -> System.out.println("\tfilter(): " + p))
                .map(String::toUpperCase)
                .peek(p -> System.out.println("\tmap(): " + p))
                .sorted()
                .peek(p -> System.out.println("\tsorted(): " + p))
                .collect(Collectors.toList());    }
}
