import java.util.ArrayList;
import java.util.List;

public class NQueensRecall {
    public static void main(String[] args) {
        int n = 5;
        List<List<String>> ans = solveNQueens(n);
        for(var x: ans)
            System.out.println(x.toString());
    }

    public static List<List<String>> solveNQueens(int n) {
        List<String> board = createBoard(n);
        List<List<String>> ans = new ArrayList<>();
        nQueensSolutions(n, board, ans, 0, 0);
        return ans;
    }

    static void nQueensSolutions(int n, List<String> board, List<List<String>> ans, int r, int c){
        if(r >= board.size()){
            ans.add(new ArrayList<>(board));
            return;
        }

        if(c >= board.size())
            return;

        if(conditions(board, r, c)){
            String s = board.get(r);
            String rep = s.substring(0, c) + "Q" + s.substring(c+1);
            board.set(r, rep);
            nQueensSolutions(n, board, ans, r+1, 0);
            board.set(r, s);
        }

        nQueensSolutions(n, board, ans, r, c+1);
    }

    static List<String> createBoard(int n){
        List<String> s = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            StringBuilder str = new StringBuilder();
            for(int j = 0; j < n; j++)
                str.append(".");

            s.add(str.toString());
        }
        return s;
    }

    static boolean conditions(List<String> board, int r, int c){
        for(int i = 0; i < r; i++){
            if(board.get(i).charAt(c) == 'Q')
                return false;
        }

        for(int row = r-1, col = c+1; row >= 0 && col < board.size(); row--, col++){
            if(board.get(row).charAt(col) == 'Q')
                return false;
        }
        for(int row = r-1, col = c-1; row >= 0 && col >= 0; row--, col--){
            if(board.get(row).charAt(col) == 'Q')
                return false;
        }

        return true;
    }
}
