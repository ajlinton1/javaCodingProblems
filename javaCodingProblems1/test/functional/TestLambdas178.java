package functional;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;
import java.util.function.Function;

import static org.hamcrest.CoreMatchers.containsString;

public class TestLambdas178 {

    @Test
    public void testFirstAndLastChar() throws Exception {
        String text = "Lambda";
        String result = firstAndLastChar.apply(text);
        Assert.assertEquals("La", result);
    }

    public static final Function<String, String> firstAndLastChar
            = (String s) -> String.valueOf(s.charAt(0))
            + String.valueOf(s.charAt(s.length() - 1));

    public static String extractCharacter(String str) {
        Random rnd = new Random();
        int nr = rnd.nextInt(str.length());
        String chAsStr = String.valueOf(str.charAt(nr));
        return chAsStr;
    }

    @Test
    public void testRndStringFromStrings() throws Exception {
        String str1 = "Some";
        String str2 = "random";
        String str3 = "text";

        String result1 = extractCharacter(str1);
        String result2 = extractCharacter(str2);
        String result3 = extractCharacter(str3);

        Assert.assertEquals(result1.length(), 1);
        Assert.assertEquals(result2.length(), 1);
        Assert.assertEquals(result3.length(), 1);
        Assert.assertThat(str1, containsString(result1));
        Assert.assertThat(str2, containsString(result2));
        Assert.assertThat(str3, containsString(result3));
    }
}
