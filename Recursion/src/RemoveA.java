public class RemoveA {
    public static void main(String[] args) {
        String s = "bcdaaabdcafd";

        System.out.println(remove(s));
//        System.out.println(remove2(s));
//        System.out.println(remove3(s, 0));
//        System.out.println(skipApple("an apple a day, keeps the apple man busy"));
//        System.out.println(skipAppNotApple("an apple a day, appkappeeps the appapple man busy"));

    }

    static String remove(String s){
        if(s.isEmpty())
            return "";

        int i = 0;
        while (i < s.length()){
            if(s.charAt(i) != 'a')
                return s.charAt(i) + remove(s.substring(i+1));
            i++;
        }
        return "";
    }

    static String remove2(String s){
        if(s.isEmpty())
            return "";

        return (s.charAt(0) != 'a' ? s.charAt(0) : "") + remove2(s.substring(1));
    }

    static String remove3(String s, int ind){
        if(ind >= s.length())
            return "";

        return (s.charAt(ind) != 'a' ? s.charAt(ind) : "") + remove3(s, ++ind);
    }

    static String skipApple(String s){
        if(s.isEmpty())
            return "";

        if(s.startsWith("apple"))
            return skipApple(s.substring(5));
        return s.charAt(0) + skipApple(s.substring(1));
    }

    static String skipAppNotApple(String s){
        if(s.isEmpty())
            return "";

        if(s.startsWith("app") && !s.startsWith("apple"))
            return skipAppNotApple(s.substring(3));
        return s.charAt(0) + skipAppNotApple(s.substring(1));
    }
}
