package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(1));
        Integer[] prev = new Integer[]{1};
        for (int i = 2; i <= numRows; i++) {
            Integer[] cur = new Integer[i];
            cur[0] = 1;
            cur[cur.length - 1] = 1;
            int l = 0, r = cur.length - 2;
            int start = 1, end = cur.length - 2;
            while (l < r) {
                cur[start++] = prev[l] + prev[l + 1];
                cur[end--] = prev[r] + prev[r - 1];
                l++;
                r--;
            }
            res.add(Arrays.asList(cur));
            prev = Arrays.copyOf(cur, cur.length);
        }
        return res;
    }
}
