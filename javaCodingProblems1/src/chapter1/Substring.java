package chapter1;

public class Substring {

    public static boolean containsSubstring(String mainString, String targetString) {
        return mainString.indexOf(targetString) != -1;
    }

    public static int count(String mainString, String targetString) {
        int n = targetString.length();
        int count = 0;
        int pos = 0;
        do {
            pos = mainString.indexOf(targetString, pos);
            if (pos > -1) {
                count++;
                pos = pos + n;
            }
        } while (pos > -1);

        return count;
    }
}
