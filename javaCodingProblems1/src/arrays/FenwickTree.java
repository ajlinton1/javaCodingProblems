package arrays;

public class FenwickTree {
    private final int n;
    private long[] tree;

    public FenwickTree(long[] values) {

        values[0] = 0L;
        this.n = values.length;
        tree = values.clone();

        for (int i = 1; i < n; i++) {

            int parent = i + lsb(i);
            if (parent < n) {
                tree[parent] += tree[i];
            }
        }
    }

    private static int lsb(int i) {

        return i & -i;

        // or
        // return Integer.lowestOneBit(i);
    }

    public long sum(int left, int right) {

        return prefixSum(right) - prefixSum(left - 1);
    }

    private long prefixSum(int i) {

        long sum = 0L;

        while (i != 0) {
            sum += tree[i];
            i &= ~lsb(i); // or, i -= lsb(i);
        }

        return sum;
    }

    public void add(int i, long v) {

        while (i < n) {
            tree[i] += v;
            i += lsb(i);
        }
    }

    public void set(int i, long v) {
        add(i, v - sum(i, i));
    }
}
