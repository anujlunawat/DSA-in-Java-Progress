import java.util.Arrays;

public class CheckIfTwoStringArraysAreEquivalent1662 {
    public static void main(String[] args) {
        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};
        System.out.println(arrayStringsAreEqual(word1, word2));
        System.out.println(arrayStringsAreEqualPart2(word1, word2));
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String word1cpy = (Arrays.toString(word1).replaceAll(", ", ""));
        String word2cpy = (Arrays.toString(word2).replaceAll(", ", ""));
        return word1cpy.equals(word2cpy);
    }

    public static boolean arrayStringsAreEqualPart2(String[] word1, String[] word2){
        StringBuilder word1cpy = new StringBuilder();
        StringBuilder word2cpy = new StringBuilder();

        for(String x: word1)
            word1cpy.append(x);
        for(String x: word2)
            word2cpy.append(x);

        return word1cpy.compareTo(word2cpy) == 0;
    }
}
