package al;

import java.util.Random;

public class RSelect2 {

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }


    public int partition(int[] nums, int left, int right, int pivot_index) {
        int pivot = nums[pivot_index];
        // 1. move pivot to end
        swap(nums, pivot_index, right);
        int store_index = left;

        // 2. move all smaller elements to the left
        for (int i = left; i <= right; i++) {
            if (nums[i] < pivot) {
                swap(nums, store_index, i);
                store_index++;
            }
        }

        // 3. move pivot to its final place
        swap(nums, store_index, right);

        return store_index;
    }

    public int quickselect(int[] nums, int left, int right, int k_smallest) {
    /*
    Returns the k-th smallest element of list within left..right.
    */

        if (left == right) // If the list contains only one element,
            return nums[left];  // return that element

        // select a random pivot_index
        Random random_num = new Random();
        int pivot_index = left + random_num.nextInt(right - left);

        pivot_index = partition(nums, left, right, pivot_index);

        // the pivot is on (N - k)th smallest position
        if (k_smallest == pivot_index)
            return nums[k_smallest];
            // go left side
        else if (k_smallest < pivot_index)
            return quickselect(nums, left, pivot_index - 1, k_smallest);
        // go right side
        return quickselect(nums, pivot_index + 1, right, k_smallest);
    }

    public int findKthLargest(int[] nums, int k) {
        int size = nums.length;
        // kth largest is (N - k)th smallest
//        return quickselect(nums, 0, size - 1, size - k);
        return quickselect(nums, 0, size - 1, k);
    }

    public static void main(String[] args) {
        RSelect2 rs2 = new RSelect2();
        System.out.println("([1, 2, 3, 4, 5, 6, 7, 8], 4) 5 == \n" + rs2.findKthLargest(new int[]{5, 4, 1, 8, 7, 2, 6, 3}, 4));
        System.out.println("([1, 2, 3, 4, 5, 6, 7, 8,15], 5) 6 == \n" + rs2.findKthLargest(new int[]{5, 15, 4, 1, 8, 7, 2, 6, 3}, 5));
//        System.out.println("[] == \n" + rs.rSelect(new int[]{}, 2));
//        System.out.println("[1] == \n" + rs.rSelect(new int[]{1}, 1));
//        System.out.println("[1, 2, 2, 2, 2] == \n" + rs.rSelect(new int[]{2, 2, 2, 1, 2}, 3));
    }

}
