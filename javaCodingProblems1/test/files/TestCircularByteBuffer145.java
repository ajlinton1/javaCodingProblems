package files;

import org.junit.Assert;
import org.junit.Test;

public class TestCircularByteBuffer145 {

    @Test
    public void testCircularByteBuffer() {
        var circularByteBuffer = new CircularByteBuffer(8);
        var s = "Hello";
        circularByteBuffer.put(s.getBytes(), 0, s.length());
        var b = new byte[10];
        circularByteBuffer.get(b, 0, s.length());
        var s1 = new String(b);
        Assert.assertNotNull(s1);

        var s2 = "World";
        circularByteBuffer.put(s2.getBytes(), 0, s2.length());
        var b1 = new byte[100];
        circularByteBuffer.get(b1, 0, s2.length());
        var s3 = new String(b1);
        Assert.assertNotNull(s3);
    }

    @Test
    public void testCircularByteBuffer1() {
        var circularByteBuffer = new CircularByteBuffer(25);
        var s = "Hello";
        circularByteBuffer.put(s.getBytes(), 0, s.length());
        var b = new byte[10];
        circularByteBuffer.get(b, 0, s.length());
        var s1 = new String(b);
        Assert.assertNotNull(s1);

        var s2 = "World";
        circularByteBuffer.put(s2.getBytes(), 0, s2.length());
        var b1 = new byte[100];
        circularByteBuffer.get(b1, 0, s2.length());
        var s3 = new String(b1);
        Assert.assertNotNull(s3);
    }

}
