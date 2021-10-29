package sliding_window;

class DutchFlag {

    public static void sort(int[] arr) {
        int left = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                swap(arr, i, left++);
            }
        }
        int right = arr.length - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 2) {
                swap(arr, i, right--);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Time complexity
     * The time complexity of the algorithm will be O(N) as we are iterating the input array only once.
     * <p>
     * Space complexity
     * The algorithm runs in constant space O(1).
     */
    public static void sort2(int[] arr) {
        // all elements < low are 0 and all elements > high are 2
        // all elements from >= low < i are 1
        int low = 0, high = arr.length - 1;
        for (int i = 0; i <= high; ) {
            if (arr[i] == 0) {
                swap(arr, i, low);
                // increment 'i' and 'low'
                i++;
                low++;
            } else if (arr[i] == 1) {
                i++;
            } else { // the case for arr[i] == 2
                swap(arr, i, high);
                // decrement 'high' only, after the swap the number at index 'i' could be 0, 1 or 2
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 2, 1, 0};
        DutchFlag.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[]{2, 2, 0, 1, 2, 0};
        DutchFlag.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
    }
}
