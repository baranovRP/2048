package cyclicsort;

import java.util.ArrayList;
import java.util.List;

class AllMissingNumbers {

    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1;
            if (nums[i] != nums[j]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                missingNumbers.add(i + 1);
            }
        }
        return missingNumbers;
    }

    /**
     * Time complexity
     * The time complexity of the algorithm is O(n).
     * <p>
     * Space complexity
     * Ignoring the space required for the output array, the algorithm runs in constant space O(1).
     */
    public static List<Integer> findNumbers2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }

        List<Integer> missingNumbers = new ArrayList<>();
        for (i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                missingNumbers.add(i + 1);

        return missingNumbers;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        List<Integer> missing = AllMissingNumbers.findNumbers(new int[]{2, 3, 1, 8, 2, 3, 5, 1});
        System.out.println("Missing numbers: " + missing);

        missing = AllMissingNumbers.findNumbers(new int[]{2, 4, 1, 2});
        System.out.println("Missing numbers: " + missing);

        missing = AllMissingNumbers.findNumbers(new int[]{2, 3, 2, 1});
        System.out.println("Missing numbers: " + missing);
    }
}

