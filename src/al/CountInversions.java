package al;

import java.util.Arrays;

public class CountInversions {

    /**
     * Sort and count inversions
     *
     * @param arr
     * @param leftIdx
     * @param rightIdx
     * @return counter of inversions
     */
    public int sortAndCount(int[] arr, int leftIdx, int rightIdx) {

        // Keeps track of the inversion count at a
        // particular node of the recursion tree
        int inversion = 0;

        if (leftIdx < rightIdx) {
            int middleIdx = leftIdx + (rightIdx - leftIdx) / 2;

            // Total inversion count = left subarray count + right subarray count + merge count

            // Left subarray count
            inversion += sortAndCount(arr, leftIdx, middleIdx);

            // Right subarray count
            inversion += sortAndCount(arr, middleIdx + 1, rightIdx);

            // Merge count
            inversion += mergeAndCountSplitInv(arr, leftIdx, middleIdx, rightIdx);
        }

        return inversion;
    }


    /**
     * Count the number of split inversions during the merge process
     *
     * @param arr
     * @param leftIdx
     * @param middleIdx
     * @param rightIdx
     * @return split inversion's counter
     */
    private int mergeAndCountSplitInv(int[] arr, int leftIdx, int middleIdx, int rightIdx) {

        // Left subarray
        int[] left = Arrays.copyOfRange(arr, leftIdx, middleIdx + 1);

        // Right subarray
        int[] right = Arrays.copyOfRange(arr, middleIdx + 1, rightIdx + 1);

        int i = 0, j = 0, k = leftIdx, splitInversion = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                splitInversion += (middleIdx + 1) - (leftIdx + i);
            }
        }
        while (i < left.length)
            arr[k++] = left[i++];
        while (j < right.length)
            arr[k++] = right[j++];
        return splitInversion;
    }

    public static void main(String[] args) {
        CountInversions ci = new CountInversions();
        int[] arr = {1, 3, 5, 2, 4, 6};
        System.out.println("135246 => {3,2}, {5,2}, {5,4} : " + ci.sortAndCount(arr, 0, arr.length - 1));
    }
}
