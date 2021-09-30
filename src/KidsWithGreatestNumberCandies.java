import java.util.ArrayList;
import java.util.List;

class KidsWithGreatestNumberCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int length = candies.length;
        int max = candies[0];
        List<Boolean> res = new ArrayList();
        for (int i = 1; i < length; i++) {
            max = Math.max(max, candies[i]);
        }
        for (int candy : candies) {
            boolean result = candy + extraCandies >= max;
            res.add(result);
        }
        return res;
    }
}