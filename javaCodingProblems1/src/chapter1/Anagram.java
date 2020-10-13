package chapter1;

import java.util.List;

public class Anagram {

/*    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        List<String> permutations = Permutations.getPermutations(a);
        for (String c: permutations) {
            if (c.equals(b)) {
                return true;
            }
        }

        return false;
    } */

    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        boolean ret = true;

        int[] charCount = new int[256];
        char[] char1 = a.toCharArray();
        char[] char2 = b.toCharArray();

        for (int i = 0; i < a.length(); i++) {
            charCount[char1[i]]++;
            charCount[char2[i]]--;
        }

        for (int i = 0; i < 256; i++) {
            if (charCount[i] != 0) {
                return false;
            }
        }

        return ret;
    }

}
