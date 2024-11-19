public class PermutationSeq60 {
    public static void main(String[] args) {
        permutations("123", "", 0);
    }

    private static void permutations(String up, String p, int k){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }


        for(int i = p.length(); i >= 0; i--){
            String temp = p.substring(0, i) + up.charAt(0) + p.substring(i);
            permutations(up.substring(1), temp, k);
        }
//        if(p.isEmpty())
//            permutations(up.substring(1),  up.charAt(0) + p, k);
    }
}
