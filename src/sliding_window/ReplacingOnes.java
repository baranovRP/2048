package sliding_window;

class ReplacingOnes {
    public static int findLength(int[] arr, int k) {
        int windowStart = 0, maxLength=0, repeat0Counter = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            int right = arr[windowEnd];
            if (right == 0) {
                repeat0Counter++;
            }
            while (repeat0Counter > k) {
                int left = arr[windowStart];
                if (left == 0) {
                    repeat0Counter--;
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    /**
     * Time Complexity
     * The above algorithm’s time complexity will be O(N), where ‘N’ is the count of numbers in the input array.
     *
     * Space Complexity
     * The algorithm runs in constant space O(1).
     */
    public static int findLength2(int[] arr, int k) {
        int windowStart = 0, maxLength = 0, maxOnesCount = 0;
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if (arr[windowEnd] == 1)
                maxOnesCount++;

            // current window size is from windowStart to windowEnd, overall we have a maximum of 1s
            // repeating a maximum of 'maxOnesCount' times, this means that we can have a window with
            // 'maxOnesCount' 1s and the remaining are 0s which should replace with 1s.
            // now, if the remaining 0s are more than 'k', it is the time to shrink the window as we
            // are not allowed to replace more than 'k' Os
            if (windowEnd - windowStart + 1 - maxOnesCount > k) {
                if (arr[windowStart] == 1)
                    maxOnesCount--;
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("input: [0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1]"
                + " output: " + findLength(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2)
                + " expected: 6");
        System.out.println("input: [0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1]"
                + " output: " + findLength(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3)
                + " expected: 9");
    }
}
