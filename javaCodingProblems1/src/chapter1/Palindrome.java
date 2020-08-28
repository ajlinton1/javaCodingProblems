package chapter1;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {

    public static boolean isPalindrome(String inString) {
        boolean ret = true;
        if (inString == null || inString == "" || inString.length()==0) {
            return false;
        }
        String inString1 = inString.toLowerCase();

        String[] inString2 = inString1.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<inString2.length; i++) {
            sb.append(inString2[i]);
        }
        String inString3 = sb.toString();

        int p1 = 0;
        int p2 = inString3.length()-1;
        while (p1 < p2) {
            char c1 = inString3.charAt(p1);
            char c2 = inString3.charAt(p2);
            if (c1!=c2) {
                return false;
            }
            p1++;
            p2--;
        }
        return ret;
    }
}
