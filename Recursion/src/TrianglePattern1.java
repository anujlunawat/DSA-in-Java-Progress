public class TrianglePattern1 {
    public static void main(String[] args) {
//        trianglePattern(10);
//        trianglePattern1(5,5);
        trianglePattern2(3,0);
    }

    static void trianglePattern(int n){
        if (n == 0)
            return;

        for(int i=0; i<n; i++)
            System.out.print("* ");
        System.out.println();

        trianglePattern(--n);
    }
    static void trianglePattern1(int row, int col){
        if (col == 0){
            row--;
            col = row;
            System.out.println();
        }
        if(row == 0)
            return;

        System.out.print("* ");
        trianglePattern1(row, --col);
    }

    static void trianglePattern2(int row, int col){
        if(row == 0)
            return;

        if (col == row){
            trianglePattern2(--row, 0);
            System.out.println();
        }
        else{
            trianglePattern2(row, ++col);
            System.out.print("* ");
        }
    }
}
