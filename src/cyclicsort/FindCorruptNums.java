package cyclicsort;

class FindCorruptNums {

    public static int[] findNumbers(int[] nums) {
        int i = 0, duplicate = -1;
        while (i < nums.length) {
            if (i + 1 != nums[i]) {
                if (nums[i] != nums[nums[i] - 1]) {
                    swap(nums, i, nums[i] - 1);
                } else {
                    duplicate = nums[i];
                    i++;
                }
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) return new int[]{duplicate, i + 1};
        }
        return new int[]{-1, -1};
    }

    public static int[] findNumbers2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }

        for (i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                return new int[]{nums[i], i + 1};

        return new int[]{-1, -1};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Time complexity
     * The time complexity of the above algorithm is O(n).
     * <p>
     * Space complexity#
     * The algorithm runs in constant space O(1).
     */
    public static void main(String[] args) {
        int[] nums = FindCorruptNums.findNumbers2(new int[]{3, 1, 2, 5, 2});
        System.out.println(nums[0] + ", " + nums[1]);
        nums = FindCorruptNums.findNumbers2(new int[]{3, 1, 2, 3, 6, 4});
        System.out.println(nums[0] + ", " + nums[1]);
    }

}
