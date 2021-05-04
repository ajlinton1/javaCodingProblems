package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestArray107 {

    @Test
    public void testNextGreaterElement() {
        var a = ArrayService.getRandomArray();
        for (var i=0;i<a.length;i++) {
            var nextGreaterElement = -1;
            for (var h=i+1;h<a.length;h++) {
                if (a[h]>a[i]) {
                    nextGreaterElement = a[h];
                    break;
                }
            }
            System.out.print(a[i]);
            System.out.println(" : ");
            System.out.println(nextGreaterElement);
        }
    }

}
