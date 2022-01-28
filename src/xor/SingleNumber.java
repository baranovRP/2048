package xor;

class SingleNumber {
    public static int findSingleNumber(int[] arr) {
        int x1 = 1;
        for (int i = 2; i <= arr.length + 1; i++)
            x1 = x1 ^ 1;

        int x2 = arr[0];
        for (int i = 1; i < arr.length; i++)
            x2 = x2 ^ arr[i];

        return x1 ^ x2;
    }

    /**
     * Solution with XOR
     * Recall the following two properties of XOR:
     *     It returns zero if we take XOR of two same numbers.
     *     It returns the same number if we XOR with zero.
     * So we can XOR all the numbers in the input;
     * duplicate numbers will zero out each other and we will be left with the single number.
     * <p>
     * Time Complexity:
     * Time complexity of this solution is O(n) as we iterate through all numbers of the input once.
     * Space Complexity: The algorithm runs in constant space O(1).
     */
    public static int findSingleNumber2(int[] arr) {
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            num = num ^ arr[i];
        }
        return num;
    }

    public static void main(String args[]) {
        System.out.println(findSingleNumber2(new int[]{1, 4, 2, 1, 3, 2, 3}));
        System.out.println(findSingleNumber(new int[]{1, 4, 2, 1, 3, 2, 3}));
    }
}
