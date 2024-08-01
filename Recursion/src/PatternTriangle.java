public class PatternTriangle {
    public static void main(String[] args) {
//        pattern1(5, 5);
//        pattern2(5, 0);
        pattern3(2, 0);
    }

    static void pattern1(int row, int col){
        if(row < 1)
            return;
        for (int i = 0; i < col; i++)
            System.out.print("* ");
        System.out.println();
        pattern1(row-1, col-1);
    }

    static void pattern2(int row, int col){
        if(row < 1)
            return;
        if(col < row){
            System.out.print("* ");
            pattern2(row, col+1);
        }
        else{
            System.out.println();
            pattern2(row-1, 0);
        }
    }

    static void pattern3(int row, int col){
        if(row < 1)
            return;
        if(col < row){
            pattern3(row, col+1);
            System.out.print("* ");
        }
        else{
            pattern3(row-1, 0);
            System.out.println();
        }
    }
}
