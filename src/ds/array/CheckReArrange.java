package ds.array;

public class CheckReArrange {

    public static void reArrange(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            if (arr[start] >= 0 && arr[end] < 0) {
                int temp = arr[start];
                arr[start++] = arr[end];
                arr[end--] = temp;
            } else if (arr[start] < 0) {
                start++;
            } else if (arr[end] >= 0) {
                end--;
            }
        }
    }

    /**
     * Time Complexity
     * The time complexity of this algorithm is O(n),
     * with no extra space used as the entire array is iterated over once.
     */
    //Re-Arrange Positive and Negative Values of Given Array
    public static void reArrange2(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {   // if negative number found
                if (i != j) {
                    int temp = arr[i];
                    arr[i] = arr[j]; // swapping with leftmost positive
                    arr[j] = temp;
                }
                j++;
            }
        }
    } //end of reArrange()

    public static void main(String args[]) {

        int[] arr = {2, 4, -6, 8, -5, -10};

        System.out.print("Array before re-arranging: ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();

        reArrange(arr);

        System.out.print("Array after rearranging: ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
