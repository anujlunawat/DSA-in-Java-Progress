import java.util.Arrays;
import java.util.Objects;

class NQueensWithoutLoop {
    public static void main(String[] args) {
        String[][] board = {
                {"X", "X", "X", "X"},
                {"X", "X", "X", "X"},
                {"X", "X", "X", "X"},
                {"X", "X", "X", "X"},
        };
        nQueensProblemStr(board, 0, 0);
    }

    static void nQueensProblemStr(String[][] board, int r, int c){
        if(r >= board.length) {
            for(String[] x: board)
                System.out.println(Arrays.toString(x));
            System.out.println();
            return;
        }

        if(c >= board.length) {
            return;
        }

        if(conditions(board, r, c)) {
            board[r][c] = "Q";
            nQueensProblemStr(board, r+1, 0);
            board[r][c] = "X";
        }

        nQueensProblemStr(board, r, c+1);
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
}
