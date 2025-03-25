//https://www.geeksforgeeks.org/problems/minimum-number-of-steps-to-reach-a-given-number5234/1
//INCOMPLETE!!!!!

public class MinStepsToDestGFG {
    static int minSteps(int d) {
        return helper(0, d, 0);
    }
    static int helper(int sum, int d, int ptr){
        if(sum == d)
            return -1;

        if(sum + ptr > d){
            sum -= ptr;
        }
        else{
            sum += ptr;
        }
        return 1 + helper(sum, d, ptr + 1);
    }

    public static void main(String[] args) {
        System.out.println(minSteps(110));
    }
}
