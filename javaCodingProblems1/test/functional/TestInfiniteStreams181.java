package functional;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
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

}
