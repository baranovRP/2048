public class ValidMountainArray {
    public static void main(String[] args) {
        ValidMountainArray vma = new ValidMountainArray();
        int[] arr = {0, 3, 2, 1};
        vma.validMountainArray(arr);
    }

    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;

        int len = arr.length;
        int max = arr[0];
        int maxIdx = 0;
        for (int i = 1; i < len; i++) {
            if (max < arr[i]) {
                max = arr[i];
                maxIdx = i;
            }
        }

        if (maxIdx == 0 || maxIdx == len - 1) return false;
        int maxLIdx = maxIdx, maxRIdx = maxIdx;
        int currentL = maxIdx - 1, currentR = maxIdx + 1;
        while (currentL >= 0) {
            if (arr[maxLIdx] <= arr[currentL]) return false;
            maxLIdx--;
            currentL--;
        }
        while (currentR < len) {
            if (arr[maxRIdx] <= arr[currentR]) return false;
            maxRIdx++;
            currentR++;
        }
        return true;
    }

}
