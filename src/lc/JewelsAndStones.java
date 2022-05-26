package lc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JewelsAndStones {

    // J - jewels, S - stones
    // T=O(S*logS)
    // S=O(S)
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> stonesMap = new HashMap<>();
        int result = 0;
        for (int i = 0; i < stones.length(); i++) {
            char stone = stones.charAt(i);
            stonesMap.put(stone, (stonesMap.getOrDefault(stone, 0) + 1));
        }
        for (int i = 0; i < jewels.length(); i++) {
            result += stonesMap.getOrDefault(jewels.charAt(i), 0);
        }
        return result;
    }



//    Time Complexity: O(J.length+S.length). The O(J.length) part comes from creating J.
//    The O(S.length) part comes from searching S.
//    Space Complexity: O(J.length).

    public int numJewelsInStones2(String jewels, String stones) {
        Set<Character> jSet = new HashSet<>();
        for (char j: jewels.toCharArray())
            jSet.add(j);

        int ans = 0;
        for (char s: stones.toCharArray())
            if (jSet.contains(s))
                ans++;
        return ans;
    }
}
