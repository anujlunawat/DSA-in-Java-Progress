public class NumberOfStringsThatAppearAsSubstrings1967 {
    public static void main(String[] args) {
        String[] patterns = {"a","abc","bc","d"};
        String word = "abc";

        System.out.println(numOfStrings(patterns, word));
    }

    public static int numOfStrings(String[] patterns, String word) {
        int count = 0;

        for(String x: patterns){
            if (word.contains(x))
                count++;
        }
        return count;
    }
}
