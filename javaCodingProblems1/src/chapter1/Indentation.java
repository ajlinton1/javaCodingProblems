package chapter1;

public class Indentation {

    public static String indent(String s, int indentAmount) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i< indentAmount; i++) {
            sb.append(" ");
        }
        String indentString = sb.toString();
        sb = new StringBuilder();
        String[] parts = s.split("\n");
        for (String part: parts) {
            sb.append(indentString);
            sb.append(part);
            sb.append("\n");
        }
        return sb.toString();
    }
}
