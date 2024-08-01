public class RotateString796 {
    public static void main(String[] args) {
        String s = "abcde";
        String goal = "cdeab";
        System.out.println(rotateString(s, goal));
    }

    public static boolean rotateString(String s, String goal){
        StringBuilder ss = new StringBuilder(s);

        if(ss.toString().equals(goal))
            return true;

        for (int r = 0; r < ss.length()-1; r++) {
            ss.append(ss.charAt(0));
            ss.deleteCharAt(0);

            if(ss.toString().equals(goal))
                return true;
        }
        return false;
    }
}
