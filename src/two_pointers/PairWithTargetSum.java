package two_pointers;

import java.util.HashMap;

class PairWithTargetSum {

    public static int[] search(int[] arr, int targetSum) {
        for (int p1 = 0, p2 = arr.length - 1; p1 < p2; ) {
            if (arr[p1] + arr[p2] == targetSum) {
                return new int[]{p1, p2};
            } else if (arr[p1] + arr[p2] > targetSum) {
                p2--;
            } else {
                p1++;
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * Time Complexity
     * The time complexity of the algorithm will be O(N),
     * where ‘N’ is the total number of elements in the given array.
     * <p>
     * Space Complexity
     * The algorithm runs in constant space O(1).
     */
    public static int[] search2(int[] arr, int targetSum) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == targetSum)
                return new int[]{left, right}; // found the pair

            if (targetSum > currentSum)
                left++; // we need a pair with a bigger sum
            else
                right--; // we need a pair with a smaller sum
        }
        return new int[]{-1, -1};
    }

    /**
     * Time Complexity
     * The time complexity of the above algorithm will be O(N),
     * where ‘N’ is the total number of elements in the given array.
     * <p>
     * Space Complexity
     * The space complexity will also be O(N),
     * as, in the worst case, we will be pushing ‘N’ numbers in the HashTable.
     */
    public static int[] search3(int[] arr, int targetSum) {
        HashMap<Integer, Integer> nums = new HashMap<>(); // to store numbers and their indices
        for (int i = 0; i < arr.length; i++) {
            if (nums.containsKey(targetSum - arr[i]))
                return new int[]{nums.get(targetSum - arr[i]), i};
            else
                nums.put(arr[i], i); // put the number and its index in the map
        }
        return new int[]{-1, -1}; // pair not found
    }

    public static void main(String[] args) {
        int[] result = PairWithTargetSum.search(new int[]{1, 2, 3, 4, 6}, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = PairWithTargetSum.search(new int[]{2, 5, 9, 11}, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}