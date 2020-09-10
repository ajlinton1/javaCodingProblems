package chapter1;

public class SortArrayOfString {

    public static String[] sort(String[] inStrings) {
        boolean swapDone;
        do {
            swapDone = false;
            for (int i=0; i< inStrings.length-1; i++) {
                if (inStrings[i].length()>inStrings[i+1].length()) {
                    swapDone = true;
                    String temp = inStrings[i+1];
                    inStrings[i+1] = inStrings[i];
                    inStrings[i] = temp;
                }
            }
        } while (swapDone);
        return inStrings;
    }

}
