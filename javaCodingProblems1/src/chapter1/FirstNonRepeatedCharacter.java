package chapter1;

public class FirstNonRepeatedCharacter {

    public Character getFirstNonRepeatedCharacter(String inString) {
        int[] charCount = new int[256];
        for (int i=0; i<inString.length(); i++){
            Character current = inString.charAt(i);
            int loc = (int)current;
            charCount[loc]++;
        }
        for (int i=0; i<charCount.length; i++) {
            if (charCount[i] == 1) {
                Character c = (char)i;
                return c;
            }
        }
        return null;
    }
}
