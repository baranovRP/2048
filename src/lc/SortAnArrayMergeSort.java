package lc;

import java.util.Arrays;

public class SortAnArrayMergeSort {

    public int[] sortArray(int[] input) {
        if (input.length <= 1) {
            return input;
        }
        int mid = input.length / 2;
        int[] left = sortArray(Arrays.copyOfRange(input, 0, mid));
        int[] right = sortArray(Arrays.copyOfRange(input, mid, input.length));
        return merge(left, right);
    }

    public int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int lIdx = 0, rIdx = 0;

        for (int k = 0; k < res.length; k++) {
            if (lIdx >= left.length) {
                res[k] = right[rIdx++];
            } else if (rIdx >= right.length) {
                res[k] = left[lIdx++];
            } else if (left[lIdx] < right[rIdx]) {
                res[k] = left[lIdx++];
            } else {
                res[k] = right[rIdx++];
            }
        }
        return res;
    }
}
