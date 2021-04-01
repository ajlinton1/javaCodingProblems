package arrays;

import java.util.ArrayList;
import java.util.List;

public class Sorter {

    public static void quickSort(int[] numbers, int start, int end) {
        if (start < end) {
            var p = partition(numbers, start, end);
            quickSort(numbers, start, p-1);
            quickSort(numbers, p+1, end);
        }
    }

    static int partition(int[] numbers, int start, int end) {
        int pivot = numbers[end];
        int x = start - 1;
        for (int i = start; i < end; i++) {
            if (numbers[i] < pivot) {
                x++;
                swap(numbers, x, i);
            }
        }
        swap(numbers, x + 1, end);
        return x + 1;
    }

    static void swap(int[] numbers, int x, int y) {
        int temp = numbers[y];
        numbers[y] = numbers[x];
        numbers[x] = temp;
    }

    public static List<Integer> mergeSort(List<Integer> numbers) {
        if (numbers.size() > 1) {
            int midpoint = (numbers.size()) /2;
            var left = copyOfRange(numbers, 0, midpoint);
            var right = copyOfRange(numbers, midpoint, numbers.size());
            return merge(mergeSort(left), mergeSort(right));
        } else {
            return numbers;
        }
    }

    static List<Integer> copyOfRange(List<Integer> numbers, int start, int end) {
        var size = end - start;
        var ret = new ArrayList<Integer>();
        for (var i=start; i<end; i++) {
            ret.add(numbers.get(i));
        }
        return ret;
    }

    static List<Integer> merge(List<Integer> left, List<Integer> right) {
        int leftIndex = 0;
        int rightIndex = 0;
        List<Integer> combined = new ArrayList<>();

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) < right.get(rightIndex)) {
                combined.add(left.get(leftIndex++));
            } else {
                combined.add(right.get(rightIndex++));
            }
        }
        while (leftIndex < left.size()) {
            combined.add(left.get(leftIndex++));
        }
        while (rightIndex < right.size()) {
            combined.add(right.get(rightIndex++));
        }

        return combined;
    }

    public static int[] countingSort(int[] numbers) {
        var min = Integer.MAX_VALUE;
        var max = Integer.MIN_VALUE;
        for (var x: numbers) {
            if (x > max) {
                max = x;
            }
            if (x < min) {
                min = x;
            }
        }
        var range = max - min;
        var counter = new int[range+1];
        for (var x: numbers) {
            counter[x - min]++;
        }

        int[] ret = new int[numbers.length];
        var retIndex = 0;
        for (var h=min; h <= max; h++) {
            int numValues = counter[h-min];
            for (var i=0; i<numValues; i++) {
                ret[retIndex++] = h;
            }
        }

        return ret;
    }

    public static void heapSort(int[] numbers) {
        var n = numbers.length;
        buildHeap(numbers, n);

        while (n > 1) {
            swap(numbers, 0, n -1);
            n--;
            heapify(numbers, n, 0);
        }
    }

    private static void buildHeap(int[] arr, int n) {
        for (int i = arr.length / 2; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int greater;

        if (left < n && arr[left] > arr[i]) {
            greater = left;
        } else {
            greater = i;
        }

        if (right < n && arr[right] > arr[greater]) {
            greater = right;
        }

        if (greater != i) {
            swap(arr, i, greater);
            heapify(arr, n, greater);
        }

    }
}
