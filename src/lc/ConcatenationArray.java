package lc;

public class ConcatenationArray {

    // Time = O(n)
    public int[] getConcatenation(int[] nums) {
        int key = nums.length;
        int[] ans = new int[key * 2];
        for (int i = 0; i < key; i++) {
            ans[i] = nums[i];
            ans[i + key] = nums[i];
        }
        return ans;
    }
}
