public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int len = arr.length - 1;
        int possibleZeros = 0;
        for (int left = 0; left <= len - possibleZeros; left++) {
            if (arr[left] == 0) {
                if (left == len - possibleZeros) {
                    arr[len] = 0;
                    len--;
                    break;
                }
                possibleZeros++;
            }
        }
        for (int last = len-possibleZeros; last >= 0; last--) {
            if (arr[last] == 0) {
                arr[last+possibleZeros] = 0;
                possibleZeros--;
                arr[last+possibleZeros] = 0;
            } else {
                arr[last+possibleZeros] = arr[last];
            }
        }
    }
}
