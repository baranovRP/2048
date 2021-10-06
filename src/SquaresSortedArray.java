public class SquaresSortedArray {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int i = 0;
        int j = n -1;
        for (int k = n-1; k > -1; k--) {
            int isq = nums[i] * nums[i];
            int jsq = nums[j] * nums[j];

            if (isq < jsq) {
                res[k] = jsq;
                j--;
            } else {
                res[k] = isq;
                i++;
            }
        }
        return res;
    }
}
