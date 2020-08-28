package chapter1;

import java.util.*;

public class Permutations {

    public static List<String> getPermutationsInternal(Set<Character> uniqueChars) {
        List<String> permutations = new ArrayList<>();

        if (uniqueChars.size()>0) {
            uniqueChars.forEach(c3 -> {
                Set<Character> subSet = new HashSet<>();
                uniqueChars.forEach(c4 -> {
                    if (c4 != c3) {
                        subSet.add(c4);
                    }
                });
                List<String> subPermutations = getPermutationsInternal(subSet);
                if (subPermutations.size()>0) {
                    subPermutations.forEach((permutation) -> {
                        StringBuilder sb = new StringBuilder();
                        sb.append(c3);
                        sb.append(permutation);
                        permutations.add(sb.toString());
                    });
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(c3);
                    permutations.add(sb.toString());
                }
            });
        }
        return permutations;
    }

    public static List<String> getPermutations(String inString) {
        // Get unique characters
        Set<Character> uniqueChars = new HashSet();
        inString.chars().forEach(c1 -> {
            Character c2 = (char)c1;
            uniqueChars.add(c2);
        });

        return getPermutationsInternal(uniqueChars);
    }
}
