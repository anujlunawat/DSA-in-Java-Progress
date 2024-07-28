public class DecryptString1309 {
    public static void main(String[] args) {
        String s = "1326#";
        System.out.println(freqAlphabets(s));
    }

    public static String freqAlphabets(String s) {
        StringBuilder mapping = new StringBuilder();
        int num = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) > '2') {
                num = s.charAt(i) - 48;
                mapping.append((char)(96 + num));
            }
            else if(i < s.length()-2 && s.charAt(i+2) == '#'){
                num = ((s.charAt(i) - 48) * 10) + (s.charAt(i+1) - 48);
                mapping.append((char)(96 + num));
                i+=2;
            }

            else{
                mapping.append((char) (96 + (s.charAt(i)=='1' ? 1 : 2)));
            }
        }
        return mapping.toString();
    }
}
