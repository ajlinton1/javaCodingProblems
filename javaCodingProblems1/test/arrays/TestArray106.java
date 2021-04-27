package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestArray106 {

    @Test
    public void testFillArray() {
        var a = new int[100];
        for (var i=0;i<a.length;i++) {
            a[i] = i*2;
        }

        Assert.assertNotNull(a);
    }

    // TODO: Stream generator

}
