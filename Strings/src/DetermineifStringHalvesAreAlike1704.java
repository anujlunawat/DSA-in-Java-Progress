import java.util.Arrays;

public class DetermineifStringHalvesAreAlike1704 {
    public static void main(String[] args) {
//        System.out.println(halvesAreAlike("textbook"));
        System.out.println(halvesAreAlikePart2("textbook"));
    }

    public static boolean halvesAreAlike(String s) {
        s = s.toLowerCase();
        char[] a = new char[s.length()/2];
        char[] b = new char[s.length()/2];

        s.getChars(0, s.length()/2, a, 0);
        s.getChars(s.length()/2, s.length(), b, 0);

        int a_count = 0, b_count = 0;

        for(char c: a){
            switch (c){
                case 97:
                case 101:
                case 105:
                case 111:
                case 117:
                    a_count++;
            }
        }

        for(char c: b){
            switch (c){
                case 97:
                case 101:
                case 105:
                case 111:
                case 117:
                    b_count++;
            }
        }

        return a_count == b_count;
    }

    public static boolean halvesAreAlikePart2(String s){
        s = s.toLowerCase();
        int lcount=0, rcount=0;
        for (int i = 0; i < s.length()/2; i++) {
            switch (s.charAt(i)){
                case 97:
                case 101:
                case 105:
                case 111:
                case 117:
                    lcount++;
            }
        }
        for (int i = s.length()/2; i < s.length(); i++) {
            switch (s.charAt(i)){
                case 97:
                case 101:
                case 105:
                case 111:
                case 117:
                    rcount++;
            }
        }
        return lcount == rcount;
    }
}
