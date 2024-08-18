public class Pattern31 {
    public static void main(String[] args) {
        pattern31(4);
    }
    
    static void pattern31(int n){
        int[][] square = new int[n][n*2-1];
        for (int row = 0; row < n; row++) {
//            filling the rows with respective numbers
            for (int i = row; i < (n*2) - (1+row); i++) {
                square[row][i] = n-row;
            }
//            filling the columns
            for (int j = row+1; j < n; j++) {
                square[j][row] = n-row;
                square[j][n*2 - (2+row)] = n-row;
            }
        }

        for(int[] x: square){
            for(int y: x)
                System.out.print(y + " ");
            System.out.println();
        }

        for(int r = square.length-2; r >= 0; r--){
            for(int c = 0; c < square[r].length; c++){
                System.out.print(square[r][c] + " ");
            }
            System.out.println();
        }
    }
}
