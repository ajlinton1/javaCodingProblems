package chapter1;

import java.util.HashSet;
import java.util.Set;

public class VowelCount {

    int vowelCount = 0;
    int consonantCount = 0;
    Set<Character> vowels = new HashSet<>();

    public VowelCount(String inString) {
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        inString.chars().forEach(c -> {
            char c1 = (char) c;
            if (Character.isAlphabetic(c1)) {
                c1 = Character.toLowerCase(c1);
                if (vowels.contains(c1)) {
                    vowelCount++;
                } else {
                    consonantCount++;
                }

            }
        });
    }

    public int getVowelCount() {
        return vowelCount;
    }

    public int getConsonantCount() {
        return consonantCount;
    }
}
