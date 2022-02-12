package ds.array;

class CheckMinimum {

    /**
     * Time Complexity
     * Since the entire list is iterated over once,
     * this algorithm is in linear time, O(n).
     */
    public static int findMinimum(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= arr.length / 2; i++) {
            min = Math.min(min, arr[i]);
            min = Math.min(min, arr[arr.length - 1]);
        }
        return min;
    }

    public static void main(String args[]) {

        int[] arr = {9, 2, 1, 6};

        System.out.print("Array : ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();

        int min = findMinimum(arr);
        System.out.println("Minimum in the Array: " + min);

    }
}
