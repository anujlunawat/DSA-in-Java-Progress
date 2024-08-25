import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class NQueens51 {

    public static void main(String[] args){
        int n = 5;
        String[] board = new String[n];
        createStrArray(n, board);
        List<List<String>> t = solveNQueens(board, 0, 0);
        for(List<String> s: t){
            for(String ss: s)
                System.out.println(ss);
            System.out.println();
        }

    }


    static List<List<String>> solveNQueens1(String[][] board, int r, int c){
//        check for queens in the same column
        for (int row=r-2; row >= 0; row--) {
            if(Objects.equals(board[row][c], "Q")) {
                return new ArrayList<>();
            }
        }

//        check for upper right diagonal
        for (int row=r-2, col=c+1; row >=0 && col < board.length; row--, col++) {
            if(Objects.equals(board[row][col], "Q")) {
                return new ArrayList<>();
            }
        }

//        check for upper left diagonal
        for (int row=r-2, col=c-1; row >=0 && col >= 0; row--, col--) {
            if(Objects.equals(board[row][col], "Q")) {
                return new ArrayList<>();
            }
        }

        if(r >= board.length) {
            List<List<String>> t = new ArrayList<>();
                for (String[] strings : board) {
                    List<String> temp = new ArrayList<>(Arrays.asList(strings));
                    t.add(temp);
                }
            return t;
        }

        List<List<String>> t = new ArrayList<>();

        for (int col = 0; col < board.length; col++) {
            board[r][col] = "Q";
            t.addAll(solveNQueens1(board,r+1, col));
            board[r][col] = ".";
        }
        return t;
    }



    static List<List<String>> solveNQueens(String[] board, int r, int c){
//        check for queens in the same column
        for (int row=r-2; row >= 0; row--) {
            if(board[row].charAt(c) == 'Q') {
                return new ArrayList<>();
            }
        }

//        check for upper right diagonal
        for (int row=r-2, col=c+1; row >=0 && col < board.length; row--, col++) {
            if(board[row].charAt(col) == 'Q') {
                return new ArrayList<>();
            }
        }

//        check for upper left diagonal
        for (int row=r-2, col=c-1; row >=0 && col >= 0; row--, col--) {
            if(board[row].charAt(col) == 'Q') {
                return new ArrayList<>();
            }
        }

        if(r >= board.length) {
            List<List<String>> t = new ArrayList<>();
            t.add(new ArrayList<>(Arrays.asList(board)));
            return t;
        }

        List<List<String>> t = new ArrayList<>();

        for (int col = 0; col < board.length; col++) {
            char[] q = board[r].toCharArray();
            q[col] = 'Q';
            board[r] = new String(q);

            t.addAll(solveNQueens(board,r+1, col));

            q[col] = '.';
            board[r] = new String(q);
        }
        return t;
    }

    static void createStrArray(int n, String[] board){
        for(int i = 0; i < n; i++){
            StringBuilder s = new StringBuilder();
            for(int j = 0; j < n; j++)
                s.append(".");
            board[i] = new String(s);
        }
    }
}
