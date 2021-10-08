public class MergeSortedArray {
    public static void main(String[] args) {
        MergeSortedArray msa = new MergeSortedArray();

        int[] ints1 = {1, 2, 3, 0, 0, 0};
        int[] ints2 = {2, 5, 6};
        msa.merge(ints1, 3, ints2, 3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n - 1;
        for (int i = m - 1, j = n - 1, last = len; last >= 0; last--) {
            if (i != -1 && j != -1 && nums1[i] >= nums2[j]) {
                nums1[last] = nums1[i];
                i--;
            } else if (i != -1 && j != -1 && nums1[i] < nums2[j]) {
                nums1[last] = nums2[j];
                j--;
            } else if (j > -1 && i <= 0) {
                nums1[last] = nums2[j];
                j--;
            }
        }
    }
}
