package arrays;

public class ArrayService {

    public static int[] getRandomArray() {
        int[] a = new int[100];
        for (int i=0;i<a.length;i++) {
            double d = (Math.random()*100);
            a[i] = (int)d;
        }
        return a;
    }

    public static <T extends Comparable<T>> T max(T[] arr) {
        T max = arr[0];
        for (T elem: arr) {
            if (elem.compareTo(max) > 0) {
                max = elem;
            }
        }
        return max;
    }
}
