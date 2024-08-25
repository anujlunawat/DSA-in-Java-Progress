import java.util.Arrays;

public class NKnights {
    public static void main(String[] args) {
        String[][] board = {
                {"X", "X", "X", "X"},
                {"X", "X", "X", "X"},
                {"X", "X", "X", "X"},
                {"X", "X", "X", "X"},
        };
        System.out.println(nKnights(board, 0, 0, board.length));
    }

    static int nKnights(String[][] board, int r, int c, int target){
        if(target == 0){
            for(String[] x: board)
                System.out.println(Arrays.toString(x));
            System.out.println();
            return 1;
        }

        int sum = 0;
        for(int col = c; col <= board.length; col++){
            if (col == board.length){
                col = 0;
                r++;
            }
            if(r > board.length-1)
                return sum;

            if(conditions(board, r, col)){
                board[r][col] = "K";
                if(col < board.length - 1)
                    sum += nKnights(board, r, col+1,target - 1);
                else{
                    sum += nKnights(board, r+1, 0, target - 1);
                }
                board[r][col] = "X";
            }
        }
        return sum;
    }

    static boolean conditions(String[][] board, int r, int c){
//        bottom right
        if(r < board.length - 1 && c < board.length - 2 && board[r+1][c+2].equals("K"))
            return false;
//        bottom right 2
        if(r < board.length - 2 && c < board.length - 2 && board[r+2][c+1].equals("K"))
            return false;

//        top right
        if(r > 0 && c < board.length - 2 && board[r-1][c+2].equals("K"))
            return false;
//        top right 2
        if(r > 1 && c < board.length - 1 && board[r-2][c+1].equals("K"))
            return false;

//        top left
        if(r > 1 && c > 0 && board[r-2][c-1].equals("K"))
            return false;
//        top left 2
        if(r > 0 && c > 1 && board[r-1][c-2].equals("K"))
            return false;

//        bottom left
        if(r < board.length - 2 && c > 0 && board[r+2][c-1].equals("K"))
            return false;
//        bottom left 2
        if(r < board.length - 1 && c > 1 && board[r+1][c-2].equals("K"))
            return false;

        return true;
    }
}
