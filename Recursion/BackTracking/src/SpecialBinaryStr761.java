public class SpecialBinaryStr761 {
    static String ans = "0";

    public static void main(String[] args) {
//        System.out.println(makeString("101100101100"));
        String s = "11001111001001001010111010010010";
//        ans = s;
        ans = makeString(s, 0, 2, 2, "");
        for(int i = 2; i < s.length(); i++)
            ans = makeString(ans, 0, 2, 2, "");

        System.out.println(ans);
    }

//    private static String makeString(String s){
//        String largerString = s;
//        int value = Integer.parseInt(largerString, 2);
//
//        for(int pos = 0; pos <= s.length() - 4; pos++){
//
//           for(int len1 = 2; len1 + pos <= s.length() - pos - 2; len1+=2){
//               String str1 = s.substring(pos, pos + len1);
//               if(!checkSpecialBinary(str1, 0, 0, 0))
//                   continue;
//
//               for (int len2 = 2; len2 <= s.length() - pos - len1; len2+=2){
//                    String str2 = s.substring(pos + len1, pos + len1 + len2);
//                    if(!checkSpecialBinary(str2, 0, 0, 0) || str1.equals(str2))
//                        continue;
//
//                    String temp = s.substring(0, pos) + str2 + str1 + s.substring(pos + len1 + len2);
//                    int val = Integer.parseInt(temp, 2);
//                    if(value < val) {
//                        largerString = temp;
//                        value = val;
//                    }
//                   System.out.println(largerString);
//               }
//           }
//        }
//        return largerString;
//    }

    private static String makeString(String s, int pos, int len1, int len2, String largerString){
        if(!largerString.isEmpty()){
//            System.out.println(largerString);
            System.out.println("In function:" + largerString);
            return largerString;
        }

        if(pos > s.length() - 4){
            System.out.println("Out of range!");
            return s;
        }

        if(len1 <= s.length() - pos - len2){
            String str1 = s.substring(pos, pos + len1);

            if(checkSpecialBinary(str1, 0, 0, 0)){

                if(len2 <= s.length() - pos - len1){

                    String str2 = s.substring(pos + len1, pos + len1 + len2);
                    if(checkSpecialBinary(str2, 0, 0, 0)) {
                        String temp = s.substring(0, pos) + str2 + str1 + s.substring(pos + len1 + len2);
                        if(!str1.equals(str2) && compareStrings(ans, temp, 0)) {
                            ans = temp;
                            return makeString(s, pos, len1, len2, temp);
                        }
//                        move forward if not a greater string
                        else
                            return makeString(s, pos, len1, len2 + 2, largerString);
                    }
//                    if not str2 special binary string
                    else
                        return makeString(s, pos, len1, len2 + 2, largerString);
                }
//                len2 > allowed length
                else{
                    return makeString(s, pos, len1 + 2, 2, largerString);
                }
            }
//            if str1 is not special binary string
            else{
                return makeString(s, pos, len1 + 2, 2, largerString);
            }
        }
//        increase pos here
        else{
            return makeString(s, pos + 1, 2, 2, largerString);
        }
//        return s;
    }

    private static boolean checkSpecialBinary(String s, int pos, int ones, int zeroes){
        if(pos >= s.length()){
            return ones == zeroes;
        }

        if(ones < zeroes)
            return false;

        if(s.charAt(pos) == '1')
            return checkSpecialBinary(s, pos + 1, ones + 1, zeroes);
        return checkSpecialBinary(s, pos + 1, ones , zeroes + 1);
    }

    private static boolean compareStrings(String a, String b, int pos){
        if(pos >= a.length())
            return false;
        if(a.charAt(pos) == '1' && b.charAt(pos) != '1')
            return false;
        if(b.charAt(pos) == '1' && a.charAt(pos) != '1')
            return true;
        return compareStrings(a, b, pos+1);
    }
}
