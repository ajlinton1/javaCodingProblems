package arrays;

import org.junit.Assert;
import org.junit.Test;

public class TestFenwickTree127 {

    @Test
    public void testFenwickTree() {
        FenwickTree tree = new FenwickTree(new long[] {
                0, 3, 1, 5, 8, 12, 9, 7, 13, 0, 3, 1, 4, 9, 0, 11, 5
        });
        long sum29 = tree.sum(2, 9); // 55
        tree.set(4, 3);
        tree.add(4, 5);
    }
}
