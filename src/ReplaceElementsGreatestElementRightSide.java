import java.util.Arrays;

public class ReplaceElementsGreatestElementRightSide {
    public int[] replaceElements(int[] arr) {
        if (arr.length < 2) {
            arr[0] = -1;
        }
        int right = arr.length - 1;
        while (right - 1 >= 0) {
            if (arr[right - 1] < arr[right]) {
                arr[right - 1] = arr[right];
            }
            right--;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = -1;
        return arr;
    }
}
