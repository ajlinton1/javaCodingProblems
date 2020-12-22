package chapter1;

import org.junit.Assert;
import org.junit.Test;

import java.text.NumberFormat;
import java.util.Locale;

public class TestNumberFormatting {

    @Test
    public void formatNumber(){
        int x = 1000000;
        NumberFormat nf = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        String result = nf.format(x);
        Assert.assertEquals("1M", result);
    }

    @Test
    public void formatNumber1(){
        int x = 1000000;
        NumberFormat nf = NumberFormat.getCompactNumberInstance(Locale.ITALIAN, NumberFormat.Style.LONG);
        String result = nf.format(x);
        Assert.assertEquals("1 milione", result);
    }

    @Test
    public void parseNumber() throws java.text.ParseException
    {
        String s = "5K";
        NumberFormat nf = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        Number n = nf.parse(s);
        Assert.assertEquals(5000l, n);
    }

    @Test
    public void parseNumber1() throws java.text.ParseException
    {
        String s = "5 thousand";
        NumberFormat nf = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG);
        Number n = nf.parse(s);
        Assert.assertEquals(5000l, n);
    }

}
