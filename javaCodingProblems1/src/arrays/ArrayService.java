package arrays;

public class ArrayService {

    public static int[] getRandomArray() {
        int[] a = new int[100];
        for (int i=0;i<a.length;i++) {
            double d = (Math.random()*100) + 1;
            a[i] = (int)d;
        }
        return a;
    }
}
