package fastslowpointers;

class CircularArrayLoop {

    /**
     * Time Complexity
     * The above algorithm will have a time complexity of O(N^2) where ‘N’ is the number of elements in the array.
     * This complexity is due to the fact that
     * we are iterating all elements of the array and trying to find a cycle for each element.
     * <p>
     * Space Complexity
     * The algorithm runs in constant space O(1).
     * <p>
     * An Alternate Approach
     * In our algorithm, we don’t keep a record of all the numbers that have been evaluated for cycles.
     * We know that all such numbers will not produce a cycle for any other instance as well.
     * If we can remember all the numbers that have been visited, our algorithm will improve to O(N) as,
     * then, each number will be evaluated for cycles only once.
     * We can keep track of this by creating a separate array, however,
     * in this case, the space complexity of our algorithm will increase to O(N).
     */
    public static boolean loopExists(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean isForward = arr[i] >= 0; // if we are moving forward or not
            int slow = i, fast = i;

            // if slow or fast becomes '-1' this means we can't find cycle for this number
            do {
                slow = findNextIndex(arr, isForward, slow); // move one step for slow pointer
                fast = findNextIndex(arr, isForward, fast); // move one step for fast pointer
                if (fast != -1)
                    fast = findNextIndex(arr, isForward, fast); // move another step for fast pointer
            } while (slow != -1 && fast != -1 && slow != fast);

            if (slow != -1 && slow == fast)
                return true;
        }

        return false;
    }

    private static int findNextIndex(int[] arr, boolean isForward, int currentIndex) {
        boolean direction = arr[currentIndex] >= 0;
        if (isForward != direction)
            return -1; // change in direction, return -1

        int nextIndex = (currentIndex + arr[currentIndex]) % arr.length;
        if (nextIndex < 0)
            nextIndex += arr.length; // wrap around for negative numbers

        // one element cycle, return -1
        if (nextIndex == currentIndex)
            nextIndex = -1;

        return nextIndex;
    }

    public static void main(String[] args) {
        System.out.println(CircularArrayLoop.loopExists(new int[]{1, 2, -1, 2, 2}));
        System.out.println(CircularArrayLoop.loopExists(new int[]{2, 2, -1, 2}));
        System.out.println(CircularArrayLoop.loopExists(new int[]{2, 1, -1, -2}));
    }
}
