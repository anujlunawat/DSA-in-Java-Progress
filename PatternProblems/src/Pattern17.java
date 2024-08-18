public class Pattern17 {
    public static void main(String[] args) {
        pattern17(4);
    }

    static void pattern17(int n){
        int[][] triangle = new int[(n * 2) - 1][];

        for (int i = 0; i < n*2 - 1; i++) {
            if(i < n)
                triangle[i] = new int[i*2 + 1];
            else{
                int t = ((n-1)*2) - i;
//                System.out.println("t = " + t);
                triangle[i] = new int[(t*2)+1];
            }
            if(i < n) {
                triangle[i][0] = i + 1;
                triangle[i][triangle[i].length - 1] = i + 1;
            }
            else{
                triangle[i][0] = triangle[i-1][0]-1;
                triangle[i][triangle[i].length - 1] = triangle[i][0];
            }

            int con = (i < n ? i : (n-2)-(i-n));
            for(int j=1; j <= con; j++){
                triangle[i][j] = triangle[i][j-1]-1;
            }
            for(int j=con+1; j < triangle[i].length-1; j++){
                triangle[i][j] = triangle[i][j-1] + 1;
            }
        }

        for (int[] x: triangle){
            for (int spaces = 0; spaces < n-((x.length/2) +1); spaces++) {
                System.out.print(" ");
            }
            for (int y: x){
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}
