package subsets;

import java.util.*;

class Subsets {

    /**
     * Time complexity
     * Since, in each step, the number of subsets doubles as we add each element to all the existing subsets,
     * therefore, we will have a total of O(2^N) subsets,
     * where ‘N’ is the total number of elements in the input set.
     * And since we construct a new subset from an existing set,
     * therefore, the time complexity of the above algorithm will be O(N*2^N).
     * <p>
     * Space complexity
     * All the additional space used by our algorithm is for the output list.
     * Since we will have a total of O(2^N) subsets, and each subset can take up to O(N) space,
     * therefore, the space complexity of our algorithm will be O(N*2^N).
     */
    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for (int currentNum : nums) {
            int n = subsets.size();
            for (int i = 0; i < n; i++) {
                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(currentNum);
                subsets.add(set);
            }
        }
        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Subsets.findSubsets(new int[]{1, 3});
        System.out.println("Here is the list of subsets: " + result);

        result = Subsets.findSubsets(new int[]{1, 5, 3});
        System.out.println("Here is the list of subsets: " + result);
    }
}

