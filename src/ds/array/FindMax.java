package ds.array;

import java.util.Arrays;

class FindMax {
    public static int findMaxSumSubArray(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            max = Math.max(max, temp);

            for (int j = i+1; j < arr.length; j++) {
                temp +=arr[j];
                max = Math.max(max, temp);
            }
        }
        return max;
    }

    /**
     * Kadane’s algorithm - dynamic programming approach
     *
     * Runtime complexity
     * The runtime complexity of this solution is linear, O(n).
     *
     * Space complexity
     * The space complexity of this solution is constant, O(1).
     */
    public static int findMaxSumSubArray2(int[] arr) {
        if (arr.length < 1) {
            return 0;
        }

        int currMax = arr[0];
        int globalMax = arr[0];
        int lengtharray = arr.length;
        for (int i = 1; i < lengtharray; i++) {
            if (currMax < 0) {
                currMax = arr[i];
            } else {
                currMax += arr[i];
            }

            if (globalMax < currMax) {
                globalMax = currMax;
            }
        }
        return globalMax;
    }
    public static void main( String args[] ) {
        int[] arr1 = {1, 7, -2, -5, 10, -1};
        System.out.println("Array: "+ Arrays.toString(arr1));
        System.out.println("Sum: " + findMaxSumSubArray(arr1));
    }
}
