package lc;

public class PeakIndexInMountainArray {

    // Time = O(N)
    // Space = O(1)
    public int peakIndexInMountainArray(int[] arr) {
        int i = 0;
        while (arr[i] < arr[i + 1]) i++;
        return i;
    }

    // Time = O(logN)
    // Space = O(1)
    public int peakIndexInMountainArray2(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] < arr[m + 1]) l = m + 1;
            else r = m;
        }
        return l;
    }

}
