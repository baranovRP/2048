public class ValidMountainArray {

    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;

        boolean res = false;
        int left = 0, right = arr.length - 1;
        boolean leftStop = false, rightStop = false;
        while (left < arr.length - 1 && right > 0) {
            if (arr[left] < arr[left + 1]) {
                left++;
            } else {
                leftStop = true;
            }
            if (arr[right - 1] > arr[right]) {
                right--;
            } else {
                rightStop = true;
            }
            if (leftStop && rightStop) {
                res = left == right;
                break;
            }
        }
        return res;
    }


    //    Complexity Analysis
//
//    Time Complexity: O(N), where N is the length of A.
//
//    Space Complexity: O(1).
    public boolean validMountainArray2(int[] A) {
        int N = A.length;
        int i = 0;

        // walk up
        while (i + 1 < N && A[i] < A[i + 1])
            i++;

        // peak can't be first or last
        if (i == 0 || i == N - 1)
            return false;

        // walk down
        while (i + 1 < N && A[i] > A[i + 1])
            i++;

        return i == N - 1;
    }
}
