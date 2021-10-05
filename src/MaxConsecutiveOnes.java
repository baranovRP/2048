public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int current = 0;
        int max = 0;
        for (int num : nums) {
            if (num == 0) {
                current = 0;
            } else {
                current++;
                if (current > max) {
                    max = current;
                }
            }
        }
        return max;
    }
}
