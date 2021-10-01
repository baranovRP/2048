public class NumberGoodPairs {
    public int numIdenticalPairs(int[] A) {
        int res = 0;
        int[] count = new int[A.length];
        for (int a : A) {
            res += count[a]++;
        }
        return res;
    }
}

//Complexity
//
//        Time O(N)
//        Space O(N)
