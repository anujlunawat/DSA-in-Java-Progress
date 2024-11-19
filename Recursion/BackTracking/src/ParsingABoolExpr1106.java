import java.util.Arrays;

public class ParsingABoolExpr1106 {
    public static void main(String[] args) {
        String expr = "!(&(f,t))";
        System.out.println(parseBoolExpr(expr));
    }

    public static boolean parseBoolExpr(String expression) {
        if(expression.length() == 1)
            return expression.equals("t");
        return parseBoolExpr(conditions(expression));
    }

    public static String conditions(String expr){
        int[] loc = findInnerBracs(expr, 0, 0);
        boolean[] present = checkTrueFalse(expr, loc[0] + 1, loc[1], new boolean[]{false, false});

//        false if present
        if(present[1]){
//            true is also present
            if(present[0]){
//                if & is used
                if(expr.charAt(loc[0] - 1) == '&')
                    expr = expr.substring(0, loc[0] - 1) + 'f' + expr.substring(loc[1]+1);
                else if(expr.charAt(loc[0] - 1) == '|')
                    expr = expr.substring(0, loc[0] - 1) + 't' + expr.substring(loc[1]+1);
            }
//            true is absent
            else{
                if(expr.charAt(loc[0] - 1) == '!')
                    expr = expr.substring(0, loc[0] - 1) + 't' + expr.substring(loc[1]+1);
                else
                    expr = expr.substring(0, loc[0] - 1) + 'f' + expr.substring(loc[1]+1);
            }
        }
//        false is absent
        else{
           if(expr.charAt(loc[0] - 1) == '!')
                expr = expr.substring(0, loc[0] - 1) + 'f' + expr.substring(loc[1]+1);
            else expr = expr.substring(0, loc[0] - 1) + 't' + expr.substring(loc[1]+1);
        }

        return expr;
    }

    private static int[] findInnerBracs(String expr, int currPos, int bracStartPos){
        if(currPos >= expr.length()){
            return new int[]{-1, -1};
        }

        if(expr.charAt(currPos) == '('){
            return findInnerBracs(expr, currPos + 1, currPos);
        }
        if(expr.charAt(currPos) == ')')
            return new int[]{bracStartPos, currPos};

        return findInnerBracs(expr, currPos + 1, bracStartPos);
    }

//    present = {t-present, f-present}
    private static boolean[] checkTrueFalse(String expr, int pos, int endPos, boolean[] present){
        if(pos >= endPos)
            return present;
        if(expr.charAt(pos) == 'f')
            present[1] = true;
        else if(expr.charAt(pos) == 't')
            present[0] = true;
        if(present[0] && present[1])
            return present;
        return checkTrueFalse(expr, pos + 2, endPos, present);
    }

}
