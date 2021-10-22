package two_pointers;

class RemoveDuplicates {

    public static int remove(int[] arr) {
        int numsCounter = arr.length;
        if (numsCounter < 1) return -1;
        int prev = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (prev == arr[i]) {
                arr[i] = 0;
                numsCounter--;
            } else {
                prev = arr[i];
            }
        }
        return arr.length == numsCounter ? -1 : numsCounter;
    }

    /**
     * Time Complexity
     * The time complexity of the above algorithm will be O(N),
     * where ‘N’ is the total number of elements in the given array.
     * <p>
     * Space Complexity
     * The algorithm runs in constant space O(1).
     */
    public static int remove2(int[] arr) {
        int nextNonDuplicate = 1; // index of the next non-duplicate element
        for (int i = 1; i < arr.length; i++) {
            if (arr[nextNonDuplicate - 1] != arr[i]) {
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }

        return nextNonDuplicate;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 3, 3, 6, 9, 9};
        System.out.println(RemoveDuplicates.remove(arr));

        arr = new int[]{2, 2, 2, 11};
        System.out.println(RemoveDuplicates.remove(arr));
    }
}

