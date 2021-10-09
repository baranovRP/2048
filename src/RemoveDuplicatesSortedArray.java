public class RemoveDuplicatesSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int len = nums.length - 1;
        int i = 0;
        int val = nums[0];
        for (int j = 0; j <= len; j++) {
            if (nums[j] != val) {
                nums[i] = val;
                val = nums[j];
                i++;
            }
            if (j == len) {
                nums[i] = val;
                i++;
            }
        }
        return i;
    }

    public int removeDuplicates2(int[] nums) {
        int swap = 0;
        for(int i = 1; i<nums.length; i++){
            if(nums[i]!=nums[i-1]){
                swap++;
                nums[swap]=nums[i];

            }
        }
        return swap+1;
    }
}

