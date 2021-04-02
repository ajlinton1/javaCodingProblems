package arrays;

import org.junit.Assert;
import org.junit.Test;

public class TestSearchArray100 {

    @Test
    public void testSearchLinear() {
        var a = ArrayService.getRandomArray();
        int i = (int) Math.random() * a.length;
        var target = a[i];
        var found = false;
        var index = 0;
        while (!found && index < a.length) {
            if (a[index] == target) {
                found = true;
                break;
            }
        }

        Assert.assertTrue(found);
    }

    @Test
    public void testSearchBinary() {
        var a = ArrayService.getRandomArray();
        a = Sorter.countingSort(a);
        int i = (int) Math.random() * a.length;
        var target = a[i];

        var location = Searcher.binarySearch(target, a, 0, a.length);

        Assert.assertTrue(location > -1);
    }
}
