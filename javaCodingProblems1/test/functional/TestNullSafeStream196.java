package functional;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestNullSafeStream196 {

    @Test
    public void testNullSafeStream0() {
        System.out.println("Null element: "
                + AsStreams.elementAsStream(null).count());
        System.out.println("Non null element: "
                + AsStreams.elementAsStream("Hello world").count());
    }

    @Test
    public void testNullSafeStream1() {
        List<Integer> ints = Arrays.asList(5, null, 6, null, 1, 2);

        System.out.println("Null collection: "
                + AsStreams.collectionAsStreamWithNulls(null).count());

        System.out.println("Non-null collection with nulls: "
                + AsStreams.collectionAsStreamWithNulls(ints).count());
    }
}
