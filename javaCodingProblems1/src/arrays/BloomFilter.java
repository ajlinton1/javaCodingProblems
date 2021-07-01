package arrays;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.BitSet;

public class BloomFilter<T> {

    private BitSet bitset;
    private static final Charset CHARSET = StandardCharsets.UTF_8;
    private int numberOfAddedElements = 0;
    private int bitSetSize = 10;

    public void add(T element){
        add(element.toString().getBytes(CHARSET));
    }

    int hash(Object o) {
        return o.hashCode();
    }

    public void add(byte[] bytes) {
        int hash = hash(bytes);
        bitset.set(Math.abs(hash % bitSetSize), true);
        numberOfAddedElements++;
    }

    public boolean contains(T element) {
        return contains(element.toString().getBytes(CHARSET));
    }

    public boolean contains(byte[] bytes) {
        int hash = hash(bytes);
        if (!bitset.get(Math.abs(hash % bitSetSize))) {
            return false;
        }
        return true;
    }
}
