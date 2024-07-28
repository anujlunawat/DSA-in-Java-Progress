import java.util.Arrays;

class Scratch {
    public static void main(String[] args) {
        String[] arr = "Now is the time for all good men to come to the aid of their country".split(" ");
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j].compareToIgnoreCase(  arr[j+1]) > 0){
                    String temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for(String x: arr)
            System.out.println(x);
    }
}