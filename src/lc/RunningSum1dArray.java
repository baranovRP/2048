package lc;

public class RunningSum1dArray {

    // Time = O(n)
    // Space = O(1)
    public int[] runningSum(int[] nums) {
        int accum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            accum += nums[i];
            nums[i] = accum;
        }
        return nums;
    }

    public int[] runningSum1(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            // Result at index `i` is sum of result at `i-1` and element at `i`.
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
