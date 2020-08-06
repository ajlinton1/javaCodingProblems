package chapter1;

public class JoinStrings {

    public static String join(String s[], String delimiter) {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<s.length;i++) {
            sb.append(s[i]);
            if (i < s.length -1) {
                sb.append(delimiter);
            }
        }
        return sb.toString();
    }
}
