package sliding_window;

/**
 * Time Complexity#
 * The time complexity of the above algorithm will be O(N).
 * <p>
 * Space Complexity#
 * The algorithm runs in constant space O(1).
 */
class MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {
        int windowStart = 0;
        int windowSum = 0;
        int max = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            if (windowEnd >= k - 1) {
                max = Math.max(max, windowSum);
                windowSum -= arr[windowStart++];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int result = MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[]{2, 1, 5, 1, 3, 2});
        System.out.println("Averages of subarrays of size K: " + result);
        result = MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[]{2, 3, 4, 1, 5});
        System.out.println("Averages of subarrays of size K: " + result);
    }
}