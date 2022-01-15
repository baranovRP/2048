package subsets;

class CountUniqueTrees {

    /**
     * The time complexity of this algorithm will be exponential and will be similar to Balanced Parentheses.
     * Estimated time complexity will be O(n*2^n) but the actual time complexity ( O(4^n/\sqrt{n}) )
     * is bounded by the Catalan number and is beyond the scope of a coding interview.
     * <p>
     * Space complexity
     * The space complexity of this algorithm will be exponential too,
     * estimated O(2^n) but the actual will be ( O(4^n/\sqrt{n}).
     */
    public int countTrees(int n) {
        if (n <= 1) return 1;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            // making 'i' root of the tree
            int countOfLeftSubtrees = countTrees(i - 1);
            int countOfRightSubtrees = countTrees(n - i);
            count += (countOfLeftSubtrees * countOfRightSubtrees);
        }
        return count;
    }

    public static void main(String[] args) {
        CountUniqueTrees ct = new CountUniqueTrees();
        int count = ct.countTrees(3);
        System.out.print("Total trees: " + count);
    }
}
