import java.util.Arrays;

public class StringToInt8 {
    public static void main(String[] args) {
        String s = "  1337c0d3";
        s = s.strip();

        boolean pos = true;
        if(s.charAt(0) == '-') {
            pos = false;
            s = s.substring(1);
        }
        else if(s.charAt(0) == '+') {
            pos = true;
            s = s.substring(1);
        }

        System.out.println(intNum(s, true, 0));
    }

    static int intNum(String s, boolean sign, int num) {
        if (s.isEmpty()) {
            return num * (sign ? 1 : -1);
        }

        if (s.charAt(0) >= '0' && s.charAt(0) <= '9') {
            int mul = (int) Math.pow(10, s.length() - 1);
            num += ((s.charAt(0) - 48) * mul);
            num = intNum(s.substring(1), sign, num);
        }

        else{
            return num / (int)Math.pow(10, s.length());
        }
        return num;
    }
}