import java.util.HashSet;
import java.util.Set;

public class CheckIfNItsDoubleExist {
    public boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] * 2 == arr[j] && ( i != j)) {
                    return true;
                }
            }
        }
        return false;
    }

//    Complexity
//    Time & space: O(n), n = arr.length.
    public boolean checkIfExist2(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        for (int i : arr) {
            if (seen.contains(2 * i) || i % 2 == 0 && seen.contains(i / 2))
                return true;
            seen.add(i);
        }
        return false;
    }
}
