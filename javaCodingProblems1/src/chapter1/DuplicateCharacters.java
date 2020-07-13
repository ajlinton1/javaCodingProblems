package chapter1;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateCharacters {

    public Map<Character, Long> getCount(String inString) {
        Map<Character, Long> map = new HashMap<>();
        map = inString.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        return map;
    }
}
