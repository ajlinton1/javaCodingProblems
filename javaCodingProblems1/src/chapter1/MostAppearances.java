package chapter1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.counting;

public class MostAppearances {

    public static Character getMostAppearances(String inString) {
        Map<Character, Integer> charCount = new HashMap<>();
        inString.chars().forEach(c -> {
            Character c1 = (char) c;
            if (charCount.containsKey(c1)) {
                int count = charCount.get(c1);
                count++;
                charCount.put(c1, count);
            } else {
                charCount.put(c1, 1);
            }
        });
        AtomicReference<Character> maxChar = new AtomicReference<Character>();
        AtomicReference<Integer> maxCount = new AtomicReference<Integer>();
        maxCount.set(0);
        charCount.forEach((k,v)->{
            if (v > maxCount.get()) {
                maxCount.set(v);
                maxChar.set(k);
            }
        });

        return maxChar.get();
    }

/*    public static Character getMostAppearances1(String str) {
        return str.chars()
                .filter(c -> Character.isWhitespace(c) == false) // ignoring space
                .mapToObj(c -> (char) c)
                .collect(groupingBy(c -> c, counting()))
                .entrySet()
                .stream()
                .max(comparingByValue())
                .map(p -> Pair.of(p.getKey(), p.getValue()))
                .orElse(Pair.of(Character.MIN_VALUE, -1L));
    } */
}
