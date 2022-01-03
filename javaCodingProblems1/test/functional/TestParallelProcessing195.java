package functional;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.DoubleStream;

public class TestParallelProcessing195 {

    // Parallel processing of streams

    @Test
    public void testSumList() {
        Random rnd = new Random();
        List<Double> numbers = new ArrayList<>();

        for (int i = 0; i < 1_000_000; i++) {
            numbers.add(rnd.nextDouble());
        }
        Assert.assertNotNull(numbers);

        double result = numbers.stream()
                .reduce((a, b) -> a + b).orElse(-1d);
        Assert.assertNotEquals(-1d, result);
    }

    @Test
    public void testSumList1() throws InterruptedException, ExecutionException {
        Random rnd = new Random();
        List<Double> numbers = DoubleStream.generate(() -> rnd.nextDouble()).limit(1_000_000).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        Assert.assertNotNull(numbers);

        double result = numbers.parallelStream()
                .reduce((a, b) -> a + b).orElse(-1d);
        Assert.assertNotEquals(-1d, result);

        double result1 = numbers.stream()
                .parallel()
                .reduce((a, b) -> a + b).orElse(-1d);
        Assert.assertNotEquals(-1d, result1);

        ForkJoinPool customThreadPool = new ForkJoinPool(5);

        double result2 = customThreadPool.submit(
                () -> numbers.parallelStream()
                        .reduce((a, b) -> a + b)).get().orElse(-1d);
        Assert.assertNotEquals(-1d, result2);
    }

    @Test
    public void testSumList2() {
        int noOfProcessors = Runtime.getRuntime().availableProcessors();
        Assert.assertTrue(noOfProcessors > 1);
    }

    @Test
    public void testSpliterator() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Spliterator<Integer> s1 = numbers.spliterator();
        s1.tryAdvance(e -> System.out.println("Advancing to the first element of s1: " + e));
        System.out.println("\nEstimated size of s1: " + s1.estimateSize());
        Spliterator<Integer> s2 = s1.trySplit();
        System.out.println("Estimated size s1: " + s1.estimateSize());
        System.out.println("Estimated size s2: " + s2.estimateSize());

        s1.forEachRemaining(System.out::println); // 6, 7, 8, 9, 10
        s2.forEachRemaining(System.out::println);

        System.out.println(s1.characteristics()); // 16464
        System.out.println(s2.characteristics());

        if (s1.hasCharacteristics(Spliterator.ORDERED)) {
            System.out.println("ORDERED");
        }

        if (s1.hasCharacteristics(Spliterator.SIZED)) {
            System.out.println("SIZED");
        }
    }

}
