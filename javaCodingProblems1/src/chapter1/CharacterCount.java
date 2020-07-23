package chapter1;

import java.util.HashMap;

public class CharacterCount {

    public static Integer getCount(String inString, Character c) {
        HashMap<Character, Integer> map = new HashMap<>();
        inString.chars().forEach( c1 -> {
            Character c2 = (char)c1;
            Integer existingCount = map.get(c2);
            if (existingCount == null) {
                map.put(c2, 1);
            } else {
                existingCount++;
                map.put(c2, existingCount);
            }
        });
        return map.get(c);
    }
}
