package subsets;

import java.util.*;

class CountUniqueTreesMemoized {
    Map<Integer, Integer> map = new HashMap<>();

    /**
     * The time complexity of the memoized algorithm will be O(n^2),
     * since we are iterating from ‘1’ to ‘n’ and ensuring that each sub-problem is evaluated only once.
     * The space complexity will be O(n) for the memoization map.
     */
    public int countTrees(int n) {
        if (map.containsKey(n))
            return map.get(n);

        if (n <= 1)
            return 1;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            // making 'i' root of the tree
            int countOfLeftSubtrees = countTrees(i - 1);
            int countOfRightSubtrees = countTrees(n - i);
            count += (countOfLeftSubtrees * countOfRightSubtrees);
        }
        map.put(n, count);
        return count;
    }

    public static void main(String[] args) {
        CountUniqueTrees ct = new CountUniqueTrees();
        int count = ct.countTrees(3);
        System.out.print("Total trees: " + count);
    }
}

