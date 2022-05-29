package lc;

public class BuildArrayFromPermutation {

    public int[] buildArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] << 10;
            System.out.println(Integer.toBinaryString(nums[i]));
        }
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i] >> 10;
            System.out.println(Integer.toBinaryString(n));
            nums[i] = nums[i] + (nums[n] >> 10);
            System.out.println(Integer.toBinaryString(nums[i]));
        }
        for (int i = 0; i < nums.length; i++) {
            int mask = 1023;
            int a = mask & nums[i];
            nums[i] = a;
        }
        return nums;
    }

    public int[] buildArray1(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] + n * (nums[nums[i]] % n);
        }

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] / n;
        }

        return nums;
    }
}
