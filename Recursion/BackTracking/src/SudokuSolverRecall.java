import java.util.Arrays;

public class SudokuSolverRecall {
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

    static boolean solver(char[][] board){
        int r = -1;
        int c = -1;

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == '.'){
                    r = i;
                    c = j;
                    break;
                }
            }
            if(r != -1)
                break;
        }

        if(r == -1)
            return true;


        for(char i = '1'; i <= '9'; i++){
            if(conditions(board, r, c, i)){
                board[r][c] = i;
                if(solver(board))
                    return true;
                else
                    board[r][c] = '.';
            }
        }
        return false;
    }

    static boolean conditions(char[][] board, int row, int col, char target){
        for(int i = 0; i < board.length; i++){
            if(i != col && board[row][i] == target)
                return false;
            if(i != row && board[i][col] == target)
                return false;
        }

        int r = (row / 3) * 3;
        int c = (col / 3) * 3;

        for(int i = r; i < r+3; i++){
            for(int j = c; j < c+3; j++){
                if(i == row && j == col)
                    continue;
                if(board[i][j] == target)
                    return false;
            }
        }
        return true;
    }
}
