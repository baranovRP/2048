class ShuffleArray {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        int i = 0;
        for (int j = 0; j < 2 * n; j += 2) {
            res[j] = nums[i];
            res[j + 1] = nums[i + n];
            i++;
        }
        return res;
    }

//    COMPLEXITY:
//
//    Time: O(n) where n = nums.length
//    Space: O(1)

    public int[] shuffle2(int[] nums, int n) {
        int i = n - 1;
        for (int j = nums.length - 1; j >= n; j--) {
            nums[j] <<= 10;
            nums[j] |= nums[i];
            i--;
        }

        i = 0;
        for (int j = n; j < nums.length; j++) {
            int num1 = nums[j] & 1023;
            int num2 = nums[j] >> 10;
            nums[i] = num1;
            nums[i + 1] = num2;
            i += 2;
        }

        return nums;
    }
}

// https://leetcode.com/problems/shuffle-the-array/discuss/675956/In-Place-O(n)-Time-O(1)-Space-With-Explanation-and-Analysis