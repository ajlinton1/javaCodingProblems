package chapter1;

import java.util.Arrays;
import java.util.Comparator;

public class SortArrayOfString {

/*    public static String[] sort(String[] inStrings) {
        Arrays.sort(inStrings, (String s1, String s2) -> Integer.compare(s1.length(), s2.length()));
        return inStrings;
    } */

/*    public static String[] sort(String[] inStrings) {
        Arrays.sort(inStrings, Comparator.comparingInt(String::length));
        return inStrings;
    } */

    public static String[] sort(String[] inStrings) {
        return Arrays.stream(inStrings)
                .sorted(Comparator.comparingInt(String::length))
                .toArray(String[]::new);
    }

}
