package functional;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class TestHighOrderFunctions177 {

    // https://learning.oreilly.com/library/view/modern-java-in/9781617293566/kindle_split_033.html

    @Test
    public void testReplacer() throws Exception {

        List<String> names = Arrays.asList(
                "Ann a 15", "Mir el 28", "D oru 33");

        List<String> resultWs = replace(
                names, (String s) -> s.replaceAll("\\s", ""));
        List<String> resultNr = replace(
                names, (String s) -> s.replaceAll("\\d", ""));

        assertEquals(Arrays.asList(
                "Anna15", "Mirel28", "Doru33"), resultWs);
        assertEquals(Arrays.asList(
                "Ann a ", "Mir el ", "D oru "), resultNr);
    }

    @FunctionalInterface
    public interface Replacer<String> {
        String replace(String s);
    }

    public static List<String> replace(
            List<String> list, Replacer<String> r) {

        List<String> result = new ArrayList<>();
        for (String s: list) {
            result.add(r.replace(s));
        }

        return result;
    }

    @Test
    public void testingMethodThatReturnsFunctionalInterface() {
        Function<String, String> f1 = (String s) -> s.toUpperCase();
        Function<String, String> f2 = (String s) -> s.concat(" DONE");

        Function<String, String> f = reduceStrings(f1, f2);

        assertEquals("TEST DONE", f.apply("test"));
    }

    public static Function<String, String> reduceStrings(
            Function<String, String> ...functions) {

        Function<String, String> function = Stream.of(functions)
                .reduce(Function.identity(), Function::andThen);

        return function;
    }
}
