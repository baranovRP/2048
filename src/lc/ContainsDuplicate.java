package lc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    // Time = O(N)
    // Space = O(N)
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> present = new HashSet<>();
        for (int n : nums) {
            if (present.contains(n)) return true;
            else present.add(n);
        }
        return false;
    }

    // Time = O(NlogN)
    // Space = O(N)
    // drawback here modifies the original array by sorting it.
    // In general, it is not a good practice to modify the input
    // unless it is clear to the caller that the input will be modified.
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate cp = new ContainsDuplicate();
        System.out.println("expected: true, actual: " + cp.containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println("expected: false, actual: " + cp.containsDuplicate(new int[]{1, 2, 3, 4}));
        System.out.println("expected: false, actual: " + cp.containsDuplicate(new int[]{}));
    }
}
