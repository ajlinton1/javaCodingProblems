package arrays;

import org.junit.Assert;
import org.junit.Test;

public class TestSearchArray100 {

    @Test
    public void testSearchLinear() {
        var a = ArrayService.getRandomArray();
        int i =(int) (Math.random() * a.length);
        var target = a[i];
        var found = false;
        var index = 0;
        while (!found && index < a.length) {
            if (a[index] == target) {
                found = true;
                break;
            }
            index++;
        }

        Assert.assertTrue(found);
    }

    @Test
    public void testSearchBinary() {
        var a = ArrayService.getRandomArray();
        a = Sorter.countingSort(a);
        int i = (int) ((Math.random() * a.length));
        var target = a[i];

        var location = Searcher.binarySearch(target, a, 0, a.length - 1);

        Assert.assertTrue(location > -1);
        Assert.assertEquals(target, a[location]);
    }

    @Test
    public void testSearchLinearNotFound() {
        var a = ArrayService.getRandomArray();
        int i = (int) Math.random() * a.length;
        var target = 200;
        var found = false;
        var index = 0;
        while (!found && index < a.length) {
            if (a[index] == target) {
                found = true;
                break;
            }
            index++;
        }

        Assert.assertFalse(found);
    }

    @Test
    public void testSearchBinaryNotFound() {
        var a = ArrayService.getRandomArray();
        a = Sorter.countingSort(a);
        var target = 200;

        var location = Searcher.binarySearch(target, a, 0, a.length - 1);

        Assert.assertEquals(location, -1);
    }

}
