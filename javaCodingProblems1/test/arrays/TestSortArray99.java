package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static arrays.Sorter.mergeSort;
import static arrays.Sorter.quickSort;

public class TestSortArray99 {

    @Test
    public void testInitializeArray() {
        var a = ArrayService.getRandomArray();
        Assert.assertNotNull(a);
    }

    @Test
    public void testBubbleSort() {
        var a = ArrayService.getRandomArray();
        var swap = false;
        do {
            swap = false;
            for (var i=0;i<a.length-1;i++) {
                if (a[i]>a[i+1]) {
                    var temp = a[i+1];
                    a[i+1] = a[i];
                    a[i] = temp;
                    swap = true;
                }
            }
        } while (swap);

        var previous1 = -1;
        for (var current: a) {
            Assert.assertTrue(current >= previous1);
            previous1 = current;
        }
    }

    @Test
    public void testBubbleSort1() {
        var a = ArrayService.getRandomArray();

        for (var i = 1; i < a.length; i++) {
            for (var j = 0; j < a.length - i; j++) {
                if (a[j] > a[j + 1]) {
                    var temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }

        var previous1 = -1;
        for (var current: a) {
            Assert.assertTrue(current >= previous1);
            previous1 = current;
        }
    }

    @Test
    public void testSelectionSort() {
        // https://learning.oreilly.com/library/view/beginning-java-data/9781789537178/c6cc1057-cab6-46be-aeea-1e3610008d3d.xhtml
        var numbers = ArrayService.getRandomArray();
        var split = 0;
        while (split < numbers.length) {
            var min = Integer.MAX_VALUE;
            var minPos = Integer.MAX_VALUE;
            for (var i=split;i<numbers.length;i++) {
                if (numbers[i]<min) {
                    min = numbers[i];
                    minPos = i;
                }
            }
            var temp = numbers[split];
            numbers[split] = numbers[minPos];
            numbers[minPos] = temp;
            split++;
        }

        var previous1 = -1;
        for (var current: numbers) {
            Assert.assertTrue(current >= previous1);
            previous1 = current;
        }
    }

    @Test
    public void testQuickSort() {
        var numbers = ArrayService.getRandomArray();

        quickSort(numbers, 0, numbers.length -1);

        var previous1 = -1;
        for (var current: numbers) {
            Assert.assertTrue(current >= previous1);
            previous1 = current;
        }
    }

    // https://learning.oreilly.com/library/view/beginning-java-data/9781789537178/7112e3ee-1235-4f90-a5e0-551a9337fffb.xhtml

    @Test
    public void testMergeSort() {
        var numbers = ArrayService.getRandomArray();
        var list = new ArrayList<Integer>();
        for (var i=0;i<numbers.length;i++) {
            list.add(numbers[i]);
        }

        var sorted = mergeSort(list);

        var previous1 = -1;
        for (var current: sorted) {
            Assert.assertTrue(current >= previous1);
            previous1 = current;
        }
    }

    @Test
    public void testShuffle() {
        var numbers = ArrayService.getRandomArray();
        int[] newNumbers = new int[numbers.length];
        for (var n: newNumbers) {
            n = -1;
        }
        var pos = ArrayService.getRandomArray();
        var index = 0;
        while (index < numbers.length) {
            var newPos = pos[index];
            while (newNumbers[newPos]==-1) {
                newPos++;
                if (newPos == numbers.length) {
                    newPos = 0;
                }
            }
            newNumbers[newPos] = numbers[index];
            index++;
        }
        Assert.assertNotNull(newNumbers);
    }
}
