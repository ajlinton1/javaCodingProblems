package chapter1;

public class WhiteSpace {

    public static String remove(String inString) {
        StringBuilder sb = new StringBuilder();
        inString.chars().forEach(c-> {
            char c1 = (char)c;
            if (!Character.isWhitespace(c1)) {
                sb.append(c1);
            }
        });
        return sb.toString();
    }

}
