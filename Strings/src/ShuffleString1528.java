public class ShuffleString1528 {
    public static void main(String[] args) {
        String s = "codeleet";
        int[] indices = {4,5,6,7,0,2,1,3};
//        System.out.println(restoreString(s, indices));
        System.out.println(restoreStringOptimized(s, indices));
    }

    public static String restoreString(String s, int[] indices) {
        char[] c = s.toCharArray();
        int i=0;

        while(i < s.length()-1){
            if(indices[i] != i){
                swap(c, i, indices[i]);
                swap(indices, i, indices[i]);
            }
            else
                i++;
        }
        return new String(c);
    }

    public static void swap(int[] indices, int i, int j){
        int temp = indices[i];
        indices[i] = indices[j];
        indices[j] = temp;
    }

    public static void swap(char[] c, int i, int j){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    public static String restoreStringOptimized(String s, int[] indices){
        char[] c = new char[s.length()];

        for(int i=0; i<s.length(); i++){
            c[indices[i]] = s.charAt(i);
        }
        return new String(c);
    }
}
