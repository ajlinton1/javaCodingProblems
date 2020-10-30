package chapter1;

public class LongestCommonPrefix {

    public static String getLongestCommonPrefix(String[] s) {
        StringBuilder result = new StringBuilder();
        int pos = 0;
        while (true) {
            if (s.length == 0) {
                break;
            }
            if (s[0].length()==0) {
                break;
            }
            char currentPrefix = s[0].charAt(pos);
            for (int i=0; i<s.length; i++) {
                if (s[i].length()==pos) {
                    return result.toString();
                }
                if (s[i].charAt(pos) != currentPrefix) {
                    return result.toString();
                }
            }
            result.append(currentPrefix);
            pos++;
        }

        return result.toString();
    }

}
