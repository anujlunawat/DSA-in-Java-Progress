import java.util.Arrays;
import java.util.Objects;

public class nQueens {
    public static void main(String[] args) {
        boolean[][] board = {
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false},
        };

        String[][] board1 = {
                {"X", "X", "X", "X", "X", "X", "X", "X" },
                {"X", "X", "X", "X", "X", "X", "X", "X" },
                {"X", "X", "X", "X", "X", "X", "X", "X" },
                {"X", "X", "X", "X", "X", "X", "X", "X" },
                {"X", "X", "X", "X", "X", "X", "X", "X" },
                {"X", "X", "X", "X", "X", "X", "X", "X" },
                {"X", "X", "X", "X", "X", "X", "X", "X" },
                {"X", "X", "X", "X", "X", "X", "X", "X" },

        };
//        nQueensProblem(board, 0, 0);
        nQueensProblemStr(board1, 0);
    }

    static void nQueensProblem(boolean[][] board, int r, int c){

        for (int row=r-2; row >= 0; row--) {
            if(board[row][c]) {
                return;
            }
        }

        for (int row=r-2, col=c+1; row >=0 && col < board.length; row--, col++) {
            if(board[row][col]) {
                return;
            }
        }

        for (int row=r-2, col=c-1; row >=0 && col >= 0; row--, col--) {
            if(board[row][col]) {
                return;
            }
        }

        if(r >= board.length) {
            for(boolean[] x: board)
                System.out.println(Arrays.toString(x));
            System.out.println();
            return;
        }

        for (int col = 0; col < board.length; col++) {
            board[r][col] = true;
            nQueensProblem(board,r+1, col);
            board[r][col] = false;
        }

    }

    static void nQueensProblemStr(String[][] board, int r){
        if(r >= board.length) {
            for(String[] x: board)
                System.out.println(Arrays.toString(x));
            System.out.println();
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if(conditions(board, r, col)) {
                board[r][col] = "Q";
                nQueensProblemStr(board, r + 1);
                board[r][col] = "X";
            }
        }
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
