import java.util.Arrays;

public class Pattern16PascalsTriangle {
    public static void main(String[] args) {
        pascalsTriangle(10);
    }

    static void pascalsTriangle(int n){
        int[][] triangle = new int[n][];

        for(int i = 0; i < n; i++){
            triangle[i] = new int[i+1];
            triangle[i][0] = 1;
            triangle[i][i] = 1;

            for(int j = 1; j < i; j++){
                triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
            }
        }
        for(int[] x: triangle){
            for(int i = 0; i < n-x.length; i++)
                System.out.print(" ");
            for(int y: x){
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}
