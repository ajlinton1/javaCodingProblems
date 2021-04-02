package arrays;

public class Searcher {

    public static int binarySearch(int target, int[] a, int start, int end) {
        int mid = (end - start) / 2;
        if (a[mid] == target) {
            return mid;
        } else {
            if (target < a[mid]) {
                return binarySearch(target, a, start, mid-1);
            } else {
                return binarySearch(target, a, mid+1, end);
            }
        }

    }

}
