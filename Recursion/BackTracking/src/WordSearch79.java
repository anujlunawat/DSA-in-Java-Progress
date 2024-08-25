public class WordSearch79 {
    public static void main(String[] args) {
        char[][] board = {
                {'a', 'b', 'c', 'e'},
                {'s', 'f', 'c', 's'},
                {'a', 'd', 'e', 'e'}
        };

        String word = "see";

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if(board[row][col] == word.charAt(0))
                    if (e(board, word, row, col))
                        System.out.println(true);
            }
        }
    }

    static boolean e(char[][] board, String word, int r, int c) {
        if (word.isEmpty())
            return true;

        boolean t = false;
        //          at the position
        if (board[r][c] == word.charAt(0)) {
            board[r][c] = '.';
            t = e(board, word.substring(1), r, c);
            board[r][c] = word.charAt(0);
        }

//        to the right
        if (c < board[r].length - 1 && board[r][c + 1] == word.charAt(0) && !t) {
            board[r][c+1] = '.';
            t = e(board, word.substring(1), r, c + 1);
            board[r][c+1] = word.charAt(0);
        }

//        to the left
        if (c > 0 && board[r][c - 1] == word.charAt(0) && !t) {
            board[r][c-1] = '.';
            t = e(board, word.substring(1), r, c - 1);
            board[r][c-1] = word.charAt(0);
        }

//        above
        if (r > 0 && board[r - 1][c] == word.charAt(0) && !t) {
            board[r-1][c] = '.';
            t = e(board, word.substring(1), r - 1, c);
            board[r-1][c] = word.charAt(0);
        }

//        below
        if (r < board.length - 1 && board[r + 1][c] == word.charAt(0) && !t) {
            board[r+1][c] = '.';
            t = e(board, word.substring(1), r + 1, c);
            board[r+1][c] = word.charAt(0);
        }

        return t;
    }
}