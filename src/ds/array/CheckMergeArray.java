package ds.array;

public class CheckMergeArray {

    /**
     * Time Complexity
     * The time complexity for this algorithm is O(n+m),
     * where nnn and mmm are the sizes of arr1 and arr2, respectively.
     * This is because both arrays are iterated over once.
     * <p>
     * Space Complexity
     * O(n+m)
     */
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] res = new int[len1 + len2];
        int idx1 = 0, idx2 = 0;

        for (int i = 0; i < res.length; i++) {
            if (idx1 >= len1) {
                res[i] = arr2[idx2];
                idx2++;
            } else if (idx2 >= len2) {
                res[i] = arr1[idx1];
                idx1++;
            } else if (arr1[idx1] < arr2[idx2]) {
                res[i] = arr1[idx1];
                idx1++;
            } else {
                res[i] = arr2[idx2];
                idx2++;
            }
        }
        return res; // make a new resultant array and return your results in that
    }

    public static void main(String args[]) {

        int[] arr1 = {1, 12, 14, 17, 23}; // creating a sorted array called arr1
        int[] arr2 = {11, 19, 27};  // creating a sorted array called arr2

        int[] resultantArray = mergeArrays(arr1, arr2); // calling mergeArrays

        System.out.print("Arrays after merging: ");
        for (int i = 0; i < arr1.length + arr2.length; i++) {
            System.out.print(resultantArray[i] + " ");
        }
    }
}
