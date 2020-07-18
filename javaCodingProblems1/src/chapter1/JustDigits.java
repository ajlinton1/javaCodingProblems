package chapter1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class JustDigits {

    public static boolean isJustDigits(String inString) {

        if (inString.length()==0) {
            return false;
        }

/*        int start = (int)'0';
        int end = (int)'9';
        for (int i=0; i< inString.length(); i++) {
            char c = inString.charAt(i);
            int intValue = (int)c;
            if ((intValue < start) || (intValue > end)) {
                return false;
            }
        } */

/*        for (int i=0; i< inString.length(); i++) {
            if (!Character.isDigit(inString.charAt(i))) {
                return false;
            }
        } */

        return !inString.chars().anyMatch(c -> !Character.isDigit(c));
    }
}
