class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0, end = letters.length-1;

        while (start <= end){
            int mid_index = start + (end - start) / 2;

            if(letters[mid_index] > target)
                end = mid_index - 1;
            else
                start = mid_index + 1;
        }
        if (start >= letters.length)
            return letters[0];
        return letters[start];
    }

}

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0, end = letters.length-1;

        while (start < end){
            int mid_index = start + (end - start) / 2;

            if(letters[mid_index] > target)
                end = mid_index - 1;
            else
                start = mid_index + 1;
        }
        if (start >= letters.length)
            return letters[0];
        return letters[start];
    }

}