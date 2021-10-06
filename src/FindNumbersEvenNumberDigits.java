public class FindNumbersEvenNumberDigits {
    public int findNumbers(int[] nums) {
        int result = 0;

        for (int el : nums) {
            int amount = countDigits(el);
            if (amount % 2 == 0) {
                result++;
            }
        }
        return result;
    }

    private int countDigits(int num) {
        int counter = 0;
        int n = num;
        do {
            n /= 10;
            counter++;
        }
        while (n > 0);
        return counter;
    }

    public int findNumbers2(int[] nums) {
        int ans=0;
        for (int j : nums) {
            int num = (int) Math.log10(j) + 1;
            if (num % 2 == 0) ans++;
        }
        return ans;
    }
}

//if there are negative numbers
//if there are repeating elements
