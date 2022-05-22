import java.util.HashMap;
import java.util.Map;

public class NthFib {

    // O(2^n) time | O(n) space
    public static int getNthFibRecursive(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 1) {
            return 0;
        } else {
            return getNthFibRecursive(n - 1) + getNthFibRecursive(n - 2);
        }
    }

    // O(n) time | O(n) space
    public static int getNthFibMemoize(int n) {
        Map<Integer, Integer> memoize = new HashMap<>();
        memoize.put(1, 0);
        memoize.put(2, 1);
        return getNthFibMemoize(n, memoize);
    }

    private static int getNthFibMemoize(int n, Map<Integer, Integer> memoize) {
        if (memoize.containsKey(n)) {
            return memoize.get(n);
        } else {
            memoize.put(n, getNthFibMemoize(n - 1, memoize) + getNthFibMemoize(n - 2, memoize));
            return memoize.get(n);
        }
    }

    // O(n) time | O(1) space
    public static int getNthFibConstSpace(int n) {
        int[] lastTwo = {0, 1};
        int counter = 3;
        while (counter <= n) {
            int nextFib = lastTwo[0] + lastTwo[1];
            lastTwo[0] = lastTwo[1];
            lastTwo[1] = nextFib;
            counter++;
        }
        return n > 1 ? lastTwo[1] : lastTwo[0];
    }
}
