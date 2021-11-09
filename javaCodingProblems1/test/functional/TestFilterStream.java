package functional;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestFilterStream {

    @Test
    public void testFilterStream() {
        List<Integer> ints = Arrays.asList(1, 2, -4, 0, 2, 0, -1, 14, 0, -1);
        List<Integer> result = ints.stream()
                .filter(i -> i != 0)
                .collect(Collectors.toList());
        System.out.println(result);
    }

    @Test
    public void testFilterStream1() {
        List<Integer> ints = Arrays.asList(1, 2, -4, 0, 2, 0, -1, 14, 0, -1);
        List<Integer> result = ints.stream()
                .filter(i -> i != 0)
                .distinct()
                .skip(1)
                .limit(2)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(result);
    }

}
