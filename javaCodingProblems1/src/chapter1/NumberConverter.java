package chapter1;

import java.util.ArrayList;
import java.util.List;

public class NumberConverter {

    public static List<Object> convert(String inString) {
        Integer intValue;
        Float floatValue;
        Long longValue;
        Double doubleValue;

        List<Object> ret = new ArrayList<>();
        try {
            intValue = Integer.parseInt(inString);
            ret.add(intValue);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe.getMessage());
        }

        try {
            floatValue = Float.parseFloat(inString);
            ret.add(floatValue);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe.getMessage());
        }

        try {
            longValue = Long.parseLong(inString);
            ret.add(longValue);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe.getMessage());
        }

        try {
            doubleValue = Double.parseDouble(inString);
            ret.add(doubleValue);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe.getMessage());
        }
        return ret;
    }
}

// https://my.safaribooksonline.com/book/programming/java/9781617293566/part-4dot-everyday-java/kindle_split_024_html?query=((Java+Integer.parseInt))#snippet