package modified_binary_search;

class NextLetter {

    public static char searchNextLetter(char[] letters, char key) {
        int start = 0, end = letters.length - 1, mid = -1;
        if (key >= letters[end]) return letters[start];
        if (key <= letters[start]) return letters[end];
        while (start < end) {
            mid = start + (end - start) / 2;
            if (key < letters[mid]) end = mid - 1;
            else if (key > letters[mid]) start = mid + 1;
            else return letters[mid + 1];
        }
        return letters[mid];
    }

    /**
     * Time complexity
     * Since, we are reducing the search range by half at every step,
     * this means that the time complexity of our algorithm will be O(logN)
     * where ‘N’ is the total elements in the given array.
     * <p>
     * Space complexity
     * The algorithm runs in constant space O(1).
     */
    public static char searchNextLetter2(char[] letters, char key) {
        int n = letters.length;

        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < letters[mid]) {
                end = mid - 1;
            } else { //if (key >= letters[mid]) {
                start = mid + 1;
            }
        }
        // since the loop is running until 'start <= end', so at the end of the while loop, 'start == end+1'
        return letters[start % n];
    }


    public static void main(String[] args) {
        System.out.println(NextLetter.searchNextLetter2(new char[]{'a', 'c', 'f', 'h'}, 'f'));
        System.out.println(NextLetter.searchNextLetter(new char[]{'a', 'c', 'f', 'h'}, 'b'));
        System.out.println(NextLetter.searchNextLetter(new char[]{'a', 'c', 'f', 'h'}, 'm'));
        System.out.println(NextLetter.searchNextLetter(new char[]{'a', 'c', 'f', 'h'}, 'h'));
    }
}
