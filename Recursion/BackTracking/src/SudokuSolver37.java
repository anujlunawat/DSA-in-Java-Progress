import java.util.Arrays;

public class SudokuSolver37 {
    public static void main(String[] args) {
        char[][] board2 = {
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

        char[][] board = new char[board2.length][];

        solveSudoku2(board2, 0, 0, board);
        System.out.println();
        System.out.println();
        for(char[] x: board){
                System.out.println(Arrays.toString(x));
            }
    }

    static void solveSudoku2(char[][] board, int r, int c, char[][] board2) {
        if(r >= board.length){
            for(int i=0; i<board.length; i++){
                board2[i] = board[i].clone();
            }
            return;
        }

        if(board[r][c] == '.'){
            for (char i = '1'; i <= '9'; i++) {
                if (conditions(board, r, c, i)) {
                    board[r][c] = i;
                    if(c < board.length - 1)
                        solveSudoku2(board, r, c + 1, board2);
                    else
                        solveSudoku2(board, r+1, 0, board2);
                    board[r][c] = '.';
                }
            }
        }
        if(board[r][c] != '.') {
            if (c < board.length - 1)
                solveSudoku2(board, r, c + 1, board2);
            else
                solveSudoku2(board, r + 1, 0, board2);
        }

    }

    static boolean conditions(char[][] board, int r, int c, char num){
//        check row and col
        for(int i = 0; i < board.length; i++){
            if(board[r][i] == num || board[i][c] == num)
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
