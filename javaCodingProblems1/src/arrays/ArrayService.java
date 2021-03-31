package arrays;

public class ArrayService {

    public static int[] getRandomArray() {
        int[] a = new int[10];
        for (int i=0;i<a.length;i++) {
            double d = (Math.random()*10) + 1;
            a[i] = (int)d;
        }
        return a;
    }
}
