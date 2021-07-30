package arrays;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.BitSet;
import java.util.Objects;
import java.security.*;

public class BloomFilter<T> {

    private int bitSetSize = 100;
    private BitSet bitset = new BitSet(bitSetSize);
    private static final Charset CHARSET = StandardCharsets.UTF_8;
    private int numberOfAddedElements = 0;

    public void add(T element){
        add(element.toString().getBytes(CHARSET));
    }

    int hash(byte[] bytes) {
        int result = 0;
        for (int i=0;i<bytes.length;i++) {
            int h = bytes[i] % 7;
            result = result + h;
        }
        return result;
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

// https://en.wikipedia.org/wiki/Bloom_filter#Examples

// https://www.cs.unc.edu/~fabian/courses/CS600.624/slides/bloomslides.pdf