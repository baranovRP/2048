package lc;

public class MergeSortedArray {

    // T = O(m+n), S = O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int k = m + n - 1, i = m, j = n; k >= 0; k--) {
            if (i <= 0) nums1[k] = nums2[--j];
            else if (j <= 0) nums1[k] = nums1[--i];
            else if (nums1[i - 1] > nums2[j - 1]) nums1[k] = nums1[--i];
            else nums1[k] = nums2[--j];
        }
    }
}
