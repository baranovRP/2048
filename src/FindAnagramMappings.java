import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindAnagramMappings {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Integer> lookup = new HashMap<>();

        for(int i = 0; i < B.length; i++)
            lookup.put(B[i], i);

        int[] ans = new int[A.length];
        for(int j = 0; j < ans.length; j++)
            ans[j] = lookup.get(A[j]);

        return ans;
    }
}
