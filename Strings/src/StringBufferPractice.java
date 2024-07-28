public class StringBufferPractice {
    public static void main(String[] args) {
        StringBuffer buffer1 = new StringBuffer();
        StringBuffer buffer2 = new StringBuffer(20);
//        Sets the initial content of buffer3 to "String Buffer" and reserves room for 16 more characters w/o reallocation
        StringBuffer buffer3 = new StringBuffer("String Buffer");

//        buffer1.ensureCapacity(17);

        buffer3.setLength(25);
        System.out.println(buffer3);

        System.out.printf("buffer1:\n\tlength = %d\n\tcapacity = %d\n", buffer1.length(), buffer1.capacity());
        System.out.printf("buffer2:\n\tlength = %d\n\tcapacity = %d\n", buffer2.length(), buffer2.capacity());
        System.out.printf("buffer3:\n\tlength = %d\n\tcapacity = %d\n", buffer3.length(), buffer3.capacity());

//        buffer3.append("thisisiodncjsndnsdfnkjnwdkfnfsdsdsdggvfbsjdnvsf");
//        System.out.println();
//        System.out.println("buffer3: " + buffer3);

    }
}
