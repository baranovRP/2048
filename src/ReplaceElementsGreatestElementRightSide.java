import java.util.Arrays;

public class ReplaceElementsGreatestElementRightSide {
    public int[] replaceElements(int[] arr) {
        if (arr.length < 2) {
            arr[0] = -1;
        }
        int right = arr.length - 1;
        while (right - 1 >= 0 && arr[right - 1] < arr[right]) {
            arr[right - 1] = arr[right];
            right--;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = -1;
        return arr;
    }

//    Complexity
//
//    Time O(N)
//    Space O(1)
    public int[] replaceElements2(int[] A) {
        int mx = -1, n = A.length, a;
        for (int i = n - 1; i >= 0; --i) {
            a = A[i];
            A[i] = mx;
            mx = Math.max(mx, a);
        }
        return A;
    }
}
