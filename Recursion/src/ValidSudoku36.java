public class ValidSudoku36 {
    public static boolean isValidSudoku(char[][] board) {
        return helper(board, 0, 0);
    }

    private static boolean helper(char[][] board, int r, int c){
        if(r > board.length - 1)
            return true;
        if(c > board[0].length - 1)
            return helper(board, r + 1, 0);
        
        if(board[r][c] == '.' || conditions(board, r, c))
            return helper(board, r, c+1);
        return false;
    }

    private static boolean conditions(char[][] board, int r, int c){
        for(int i = 0; i < board.length; i++){
            if(board[i][c] == board[r][c] && i != r)
                return false;
            if(board[r][i] == board[r][c] && i != c)
                return false;
        }

        int rowStart = r - (r % 3);
        int colStart = c - (c % 3);

        for(int i = rowStart; i < rowStart + 3; i++){
            for(int j = colStart; j < colStart + 3; j++){
                if(i == r && j == c)
                    continue;
                if(board[i][j] == board[r][c])
                    return false;
            }
        }
        return true;
    }

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
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(board));
    }
}
