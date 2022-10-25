package lc;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        int N = heights.length;
        int[] copy = new int[N];
        for (int i = 0; i < N; i++) {
            copy[i] = heights[i];
        }
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && copy[j] < copy[j - 1]; j--) {
                exch(copy, j, j - 1);
            }
        }
        int count = 0;
        for (int i = 0; i < N; i++) if (copy[i] != heights[i]) count++;
        return count;
    }

    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
