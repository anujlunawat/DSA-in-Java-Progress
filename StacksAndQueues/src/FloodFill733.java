import java.util.*;

public class FloodFill733 {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
    //    top, bottom, left, right
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, +1};

        Queue<int[]> queue = new LinkedList<>();
        int target_val = image[sr][sc];

        if(target_val == color)
            return image;

        image[sr][sc] = color;
        queue.offer(new int[]{sr, sc});

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                int[] arr = queue.poll();
                int r = arr[0];
                int c = arr[1];

                for (int j = 0; j < dRow.length; j++) {
                    if(conditions(image, r + dRow[j], c + dCol[j], target_val)){
                        image[r + dRow[j]][c + dCol[j]] = color;
                        queue.offer(new int[] {r + dRow[j], c + dCol[j]});
                    }
                }
            }
        }
        return image;
    }

    private static boolean conditions(int[][] image, int r, int c, int target){
        if(!(r >= 0 && c >= 0 && r < image.length && c < image[0].length))
            return false;

        return image[r][c] == target;
    }

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1},
                        {1, 1, 0},
                        {1, 0, 1}
                        };

        floodFill(image, 1, 1, 2);
        for(int[] i: image){
            for(int j: i){
                System.out.print(j + " ");
            }
            System.out.println();
        }   
    }
}
