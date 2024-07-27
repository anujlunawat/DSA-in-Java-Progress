import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(0, 12);
        arrayList.add(1, 20);
        arrayList.add(30);
        arrayList.add(0, 40);

        System.out.println(arrayList);
        System.out.println(arrayList.size());
    }
}
