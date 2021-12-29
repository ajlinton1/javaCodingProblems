package functional;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;

public class TestParallelProcessing {

    // Parallel processing of streams

    @Test
    public void testSumList() {
        Random rnd = new Random();
        List<Double> numbers = new ArrayList<>();

        for (int i = 0; i < 1_000_000; i++) {
            numbers.add(rnd.nextDouble());
        }
        Assert.assertNotNull(numbers);
    }

    @Test
    public void testSumList1() {
        Random rnd = new Random();
        var numbers = DoubleStream.generate(() -> rnd.nextDouble()).limit(1_000_000).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        Assert.assertNotNull(numbers);
    }

}
