package lc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindAllNumbersDisappearedInArray {

    // Time = O(n)
    // Space = O(1)
    public List<Integer> findDisappearedNumbers(int[] nums) {
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

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {

        // Iterate over each of the elements in the original array
        for (int i = 0; i < nums.length; i++) {

            // Treat the value as the new index
            int newIndex = Math.abs(nums[i]) - 1;

            // Check the magnitude of value at this new index
            // If the magnitude is positive, make it negative
            // thus indicating that the number nums[i] has
            // appeared or has been visited.
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }

        // Response array that would contain the missing numbers
        List<Integer> result = new LinkedList<>();

        // Iterate over the numbers from 1 to N and add all those
        // that have positive magnitude in the array
        for (int i = 1; i <= nums.length; i++) {

            if (nums[i - 1] > 0) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindAllNumbersDisappearedInArray res = new FindAllNumbersDisappearedInArray();
        System.out.println("expected: {5, 6}, actual: " + res.findDisappearedNumbers2(new int[]{4, 3, 2, 1, 7, 8, 2, 3}));
        System.out.println("expected: {5, 6}, actual: " + res.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println("expected: {1, 5, 6, 7, 8}, actual: " + res.findDisappearedNumbers(new int[]{4, 3, 2, 2, 3, 3, 2, 3}));
    }
}
