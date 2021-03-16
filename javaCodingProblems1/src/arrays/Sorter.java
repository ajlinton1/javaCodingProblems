package arrays;

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

    public static void mergeSort(int[] numbers, int start, int end) {
        if (start < end) {
            int midpoint = (end - start) / 2 + start;
            mergeSort(numbers, start, midpoint-1);
            mergeSort(numbers, midpoint+1, end);
            merge(numbers, start, midpoint, end);
        }
    }

    static void merge(int[] number, int start, int midpoint, int end) {
        int i = start;
        int j = midpoint + 1;
        int[] arrayTemp = new int[end - start + 1];
        for (int k=0; k < (end-start); k++) {
            if ((i<=midpoint ) && ((j > end) || (number[i] <= number[j]))) {
                arrayTemp[k] = number[i];
                i++;
            } else {
                arrayTemp[k] = number[j];
                j++;
            }
        }
        for (int x=0;x<arrayTemp.length;x++){
            number[start+x] = arrayTemp[x];
        }
    }

}
