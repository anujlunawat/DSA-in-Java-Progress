class Scratch {
    public static void main(String[] args) {
        int[][] arr1 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[] arr2 = {100, 200, 300};

        for(int[] x: arr1){
            x[0] = 1000;
            for(int y: x)
                System.out.print(y + " ");
            System.out.println();
        }
        for(int[] x: arr1){
            for(int y: x)
                System.out.print(y + " ");
            System.out.println();
        }

    }
}