import java.util.*;

class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int left=0,right=nums.length-1;
        while(left<right){
            int res = nums[left]+nums[right];
            if(target==res){
                return new int[]{left,right};
            } else if(res < target){
                left++;
            } else{
                right--;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
//        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
        int[] ints = twoSum(new int[]{3,2,4}, 6);
        System.out.println(Arrays.toString(ints));
    }
}