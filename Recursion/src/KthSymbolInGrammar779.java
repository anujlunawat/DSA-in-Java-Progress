public class KthSymbolInGrammar779 {
    public static void main(String[] args) {
        System.out.println(kthSymbol(2, 2, "0") - 48);
    }

    private static char kthSymbol(int n, int k, String sym){
        if(n == 1){
            return sym.charAt(k - 1);
        }
        StringBuilder t = new StringBuilder();
        for(int i = 0; i < sym.length(); i++){
            if(sym.charAt(i) == '0')
                t.append("01");
            else
                t.append("10");
        }

        return kthSymbol(n - 1, k, t.toString());
    }
}
