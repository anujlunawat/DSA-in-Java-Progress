import java.util.Arrays;

class Scratch {
    public static void main(String[] args) {
        String s = "this is a string";

        byte[] b = s.getBytes();

        System.out.println(Arrays.toString(b));
    }
}