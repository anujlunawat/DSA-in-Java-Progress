import java.util.Arrays;

public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };


        solver(board);
        for(char[] x: board){
                System.out.println(Arrays.toString(x));
            }
    }

    static boolean solver(char[][] board) {
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyLeft = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    row = i;
                    col = j;
                    emptyLeft = true;
                    break;
                }
            }
            if (emptyLeft)
                break;
        }

        if (!emptyLeft)
            return true;

        for (char i = '1'; i <= '9'; i++) {
            if (conditions(board, row, col, i)) {
                board[row][col] = i;
                if (solver(board))
                    return true;
                else
                    board[row][col] = '.';
            }
        }
        return false;
    }

    static boolean conditions(char[][] board, int r, int c, char num){
//        check row and col
        for(int i = 0; i < board.length; i++){
            if(board[r][i] == num)
                return false;
            if(board[i][c] == num)
                return false;
        }

//        check the matrix
        int row = (r / 3) * 3;
        int col = (c / 3) * 3;

        for(int i = row; i < row+3; i++){
            for (int j = col; j < col+3; j++) {
                if(board[i][j] == num)
                    return false;
            }
        }
        return true;
    }
}
