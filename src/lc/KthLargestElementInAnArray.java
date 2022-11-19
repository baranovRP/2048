package lc;

import java.util.Arrays;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        sort(nums);
        System.out.print(Arrays.toString(nums));
        return nums[nums.length - k];
    }

    private void sort(int[] nums) {
        int n = nums.length - 1;
        for (int depth = n / 2; depth >= 0; depth--) sink(nums, depth, n);
        int length = n;
        while (length > 0) {
            exch(nums, 0, length--);
            sink(nums, 0, length);
        }
    }

    private void sink(int[] nums, int idx, int length) {
        while (2 * idx <= length) {
            int j = 2 * idx;
            if (j < length && nums[j] < nums[j + 1]) j++;
            if (!(nums[idx] < nums[j])) break;
            exch(nums, idx, j);
            idx = j;
        }
    }

    private void exch(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray kArr = new KthLargestElementInAnArray();
        System.out.println(kArr.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(kArr.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
