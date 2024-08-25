import java.util.Arrays;
import java.util.Objects;

public class NQueensII52 {
    public static void main(String[] args) {
        int n = 4;
        String[][] board = createBoard(n);

        System.out.println(nQueensII(board,0, 0));
    }

    static int nQueensII(String[][] board, int r, int c){
        if(r >= board.length){
            return 1;
        }

        if(c >= board.length){
            return 0;
        }

        int sum = 0;
        if(conditions(board, r, c)){
            board[r][c] = "Q";
            sum += nQueensII(board, r+1, 0);
            board[r][c] = "X";
        }

        sum += nQueensII(board, r, c+1);

        return sum;
    }

    static boolean conditions(String[][] board, int r, int c){
        //        check for queens in the same column
        for (int row=r-1; row >= 0; row--) {
            if(Objects.equals(board[row][c], "Q")) {
                return false;
            }
        }

//        check for upper right diagonal
        for (int row=r-1, col=c+1; row >=0 && col < board.length; row--, col++) {
            if(Objects.equals(board[row][col], "Q")) {
                return false;
            }
        }

//        check for upper left diagonal
        for (int row=r-1, col=c-1; row >=0 && col >= 0; row--, col--) {
            if(Objects.equals(board[row][col], "Q")) {
                return false;
            }
        }
        return true;
    }

    static String[][] createBoard(int n){
        String[][] board = new String[n][];
        for(int i = 0; i < n; i++){
            board[i] = new String[n];
            for (int j = 0; j < n; j++) {
                board[i][j] = "X";
            }
        }
        return board;
    }
}
