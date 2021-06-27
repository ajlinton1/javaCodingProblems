package arrays;

import org.junit.Assert;
import org.junit.Test;

public class TestUnionFind126 {

    @Test
    public void testUnionFind() {
        var disjointSet = new DisjointSet(10);

        Assert.assertNotNull(disjointSet);
    }

    @Test
    public void testUnionFind1() {
        DisjointSet set = new DisjointSet(11);
        set.union(0, 1);
        set.union(4, 9);
        set.union(6, 5);
        set.union(0, 7);
        set.union(4, 3);
        set.union(4, 2);
        set.union(6, 10);
        set.union(4, 5);

        Assert.assertFalse(set.find(0) == set.find(4));
        Assert.assertTrue(set.find(4) == set.find(5));
    }


}
