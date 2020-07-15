package chapter1;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Reversing {

    private static final Pattern PATTERN = Pattern.compile(" +");

    public static String reverseWords(String str) {
        return PATTERN.splitAsStream(str).map(w -> new StringBuilder(w).reverse())
                .collect(Collectors.joining(" "));
    }

    public String reverseWord(String inString) {
        return new StringBuilder(inString).reverse().toString();
    }
}
