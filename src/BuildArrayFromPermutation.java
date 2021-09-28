public class BuildArrayFromPermutation {
    // O(n) space complexity
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

    /*
    Constraints:

    1 <= nums.length <= 1000
    0 <= nums[i] < nums.length
    The elements in nums are distinct.

     */

    // O(1) space complexity
    /*
    But since every integer in the array has 32 bits dedicated to it in memory,
    even if some of those bits are 0, altering some of those bits is not really
    equivalent to using more memory, as we're just using the memory we already have on hand.

    1023 in this instance is the decimal representation of the binary number 1111111111.
    By applying an AND operation with this value we can be assured that
    we are only looking at the 10 least-significant digits of nums,
    since our updated values have been bit-shifted to the next 10 digits after that.

    If we don't use our mask we could end up in a situation like nums = [0,1,2,4,3]
    where nums[nums[4]] = nums[3], but by the time we get to i = 4
    we have already updated the value of nums[3] to also include nums[nums[3]] = nums[4].
    So we have to be extra careful to always use our mask to get the original value.
     */
    public int[] buildArrayWithBitwise(int[] nums) {
        int mask = 1023;
        for (int i = 0; i < nums.length; i++)
            nums[i] |= (nums[nums[i]] & mask) << 10;
        for (int i = 0; i < nums.length; i++)
            nums[i] = nums[i] >> 10;
        return nums;
    }
}
