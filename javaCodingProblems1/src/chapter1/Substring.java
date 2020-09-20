package chapter1;

public class Substring {

    public static boolean containsSubstring(String mainString, String targetString) {
        int targetPos = 0;
        boolean candidate = false;
        for (int i=0; i< mainString.length(); i++) {
            if (mainString.charAt(i) == targetString.charAt(targetPos)) {
                candidate = true;
            } else {
                candidate = false;
                targetPos = 0;
            }
            if ((candidate) && (targetPos == targetString.length()-1)) {
                return true;
            }
            targetPos++;
        }

        return false;
    }
}
