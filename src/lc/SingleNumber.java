package lc;

class SingleNumber {

    // Time = O(n)
    // Space = O(1)
    public int singleNumber(int[] nums) {
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num ^= nums[i];
        }
        return num;
    }
}
