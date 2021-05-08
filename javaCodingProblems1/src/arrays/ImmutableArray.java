package arrays;

import java.util.Arrays;

public class ImmutableArray<T> {

    private final T[] array;

    public ImmutableArray(T[] a) {
        this.array = Arrays.copyOf(a, a.length);
    }

    public T get(int i) {
        return array[i];
    }
}
