package functional;

import org.junit.Ignore;
import org.junit.Test;

import java.security.SecureRandom;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestInfiniteStreams181 {

    @Test
    @Ignore
    public void testInfiniteStream() {
        Stream.iterate(1, i -> i + 1)
                .forEach(System.out::println);
    }

    @Test
    public void testUnorderedStream() {
        List<Integer> list = Arrays.asList(1, 4, 20, 15, 2, 17, 5, 22, 31, 16);

        Stream<Integer> unorderedStream = list.stream().unordered();
        unorderedStream.forEach(System.out::println);
    }

    @Test
    public void testOrderedStream() {
        List<Integer> list = Arrays.asList(1, 4, 20, 15, 2, 17, 5, 22, 31, 16);

        Stream<Integer> unorderedStream = list.stream().sorted();
        unorderedStream.forEach(System.out::println);
    }

    @Test
    public void testOrderedStream1() {
        Stream<Integer> infStream = Stream.iterate(1, i -> i + 1);
        List<Integer> result = infStream
                .filter(i -> i % 2 == 0)
                .limit(10)
                .collect(Collectors.toList());

        result.forEach(System.out::println);
    }

    @Test
    public void testOrderedStream2() {
        Stream<Integer> infStream = Stream.iterate(1, i -> i <= 10, i -> i + 1);

        List<Integer> result = infStream
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());

        result.forEach(System.out::println);
    }

    @Test
    public void testOrderedStream3() {
        Stream<Integer> infStream = Stream.iterate(
                1, i -> i <= 10, i -> i + i % 2 == 0
                        ? new Random().nextInt(20) : -1 * new Random().nextInt(10));

        List<Integer> result = infStream
                .collect(Collectors.toList());

        result.forEach(System.out::println);
    }

    @Test
    public void testInfiniteSequentialOrderedStream() {
        Stream<Integer> infStream = Stream.iterate(1, i -> i + 1);
        List<Integer> result = infStream
                .filter(i -> i % 2 == 0)
                .limit(10)
                .collect(Collectors.toList());

        result.forEach(System.out::println);
    }

    @Test
    public void testInfiniteSequentialOrderedStream1() {
        Stream<Integer> infStream = Stream.iterate(
                1, i -> i <= 10, i -> i + 1);
        List<Integer> result = infStream
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());

        result.forEach(System.out::println);
    }

    @Test
    public void testInfiniteSequentialOrderedStream2() {
        Stream<Integer> infStream = Stream.iterate(
                1, i -> i <= 10, i -> i + i % 2 == 0
                        ? new Random().nextInt(20) : -1 * new Random().nextInt(10));
        List<Integer> result = infStream
                .limit(25)
                .collect(Collectors.toList());

        result.forEach(System.out::println);
    }

    @Test
    public void testRandomStream() {
        IntStream rndInfStream = new Random().ints(1, 100);
        List<Integer> result = rndInfStream
                .filter(i -> i % 2 == 0)
                .limit(10)
                .boxed()
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    @Test
    public void testRandomStream1() {
        IntStream rndInfStream = new Random().ints(10, 1, 100);
        List<Integer> result = rndInfStream
                .filter(i -> i % 2 == 0)
                .boxed()
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    @Test
    public void testRandomStream2() {
        IntStream rndInfStream = new Random().ints(20, 48, 126);
        String result = rndInfStream
                .mapToObj(n -> String.valueOf((char) n))
                .collect(Collectors.joining());
        System.out.println(result);
    }

    @Test
    public void testCreatePasswords() {
        Supplier<String> passwordSupplier = TestInfiniteStreams181::randomPassword;
        Stream<String> passwordStream = Stream.generate(passwordSupplier);
        List<String> result = passwordStream
                .limit(10)
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    private static String randomPassword() {

        String chars = "abcd0123!@#$";

        return new SecureRandom().ints(8, 0, chars.length())
                .mapToObj(i -> String.valueOf(chars.charAt(i)))
                .collect(Collectors.joining());
    }

    @Test
    public void testPredicate() {
        List<Integer> result = IntStream
                .iterate(1, i -> i + 1)
                .takeWhile(i -> i <= 10)
                .boxed()
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    @Test
    public void testPredicate1() {
        List<Integer> result = new Random().ints(1, 100)
                .filter(i -> i % 2 == 0)
                .takeWhile(i -> i >= 50)
                .boxed()
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    @Test
    public void testPredicate2() {
        List<Integer> result = new Random().ints(1, 100)
                .takeWhile(i -> i % 2 == 0 && i >= 50)
                .boxed()
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    @Test
    public void testPredicate3() {
        List<String> result = Stream.generate(TestInfiniteStreams181::randomPassword)
                .takeWhile(s -> s.contains("!"))
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    @Test
    public void testPredicate4() {
        Set<Integer> setOfInts = new HashSet<>(
                Arrays.asList(1, 4, 3, 52, 9, 40, 5, 2, 31, 8));

        List<Integer> result = setOfInts.stream()
                .takeWhile(i -> i<= 10)
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    @Test
    public void testPredicateDrop() {
        List<Integer> result = IntStream
                .iterate(1, i -> i + 1)
                .dropWhile(i -> i <= 10)
                .limit(5)
                .boxed()
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    @Test
    public void testPredicateDrop1() {
        List<Integer> result = new Random().ints(1, 100)
                .filter(i -> i % 2 == 0)
                .dropWhile(i -> i < 50)
                .limit(5)
                .boxed()
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    @Test
    public void testPredicateDrop2() {
        List<String> result = Stream.generate(TestInfiniteStreams181::randomPassword)
                .dropWhile(s -> !s.contains("!"))
                .limit(5)
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    @Test
    public void testPredicateDrop3() {
        Set<Integer> setOfInts = new HashSet<>(
                Arrays.asList(5, 42, 3, 2, 11, 1, 6, 55, 9, 7));

        List<Integer> result = setOfInts.stream()
                .dropWhile(i -> i <= 10)
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

}
