package chapter1;

import java.util.Set;
import java.util.stream.Collectors;

public class RemoveCharacters {

    public static String remove(String inString, Set<Character> toRemove) {
        StringBuilder sb = new StringBuilder();
        inString.chars().forEach(c -> {
            Character c1 = (char)c;
            if (!toRemove.contains(c1)) {
                sb.append(c1);
            }
        });
        return sb.toString();
    }

    public static String removeCharacter(String inString, Character toRemove) {
        return inString.chars()
                .filter(c -> c != toRemove)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }

}
