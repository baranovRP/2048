package lc;

public class LongestContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {
        int max = 0, counter = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i - 1] >= nums[i]) {
                max = Math.max(max, counter);
                counter = 1;
            } else {
                counter++;
            }
        }

        return Math.max(max, counter);
    }

    // Time = O(N)
    // Space = O(1)
    public int findLengthOfLCIS2(int[] nums) {
        int ans = 0, anchor = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i - 1] >= nums[i]) anchor = i;
            ans = Math.max(ans, i - anchor + 1);
        }
        return ans;
    }


    public static void main(String[] args) {
        LongestContinuousIncreasingSubsequence lcis = new LongestContinuousIncreasingSubsequence();
        System.out.println(lcis.findLengthOfLCIS2(new int[]{2, 2, 2}));
        System.out.println(lcis.findLengthOfLCIS2(new int[]{1, 3, 5, 4, 7}));
        System.out.println(lcis.findLengthOfLCIS2(new int[]{1, 2, 2, 1, 2, 3}));
    }
}
