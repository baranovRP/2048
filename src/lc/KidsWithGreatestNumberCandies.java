package lc;

import java.util.ArrayList;
import java.util.List;

public class KidsWithGreatestNumberCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        List<Boolean> res = new ArrayList<>();
        for (int i = 1; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }
        for (int candy : candies) {
            res.add(candy + extraCandies >= max);
        }
        return res;
    }
}
