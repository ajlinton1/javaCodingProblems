package chapter1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateCharacters {

    public Map<Character, Long> getCount(String inString) {
        Map<Character, Long> map = new HashMap<>();
        map = inString.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        return map;
    }

    public static String remove(String inString) {
        Set<Character> characters = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        inString.chars().forEach(c -> {
            Character c1 = (char)c;
            if (!characters.contains(c1)) {
                sb.append(c1);
                characters.add(c1);
            }
        });
        return sb.toString();
    }
}
