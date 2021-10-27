package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TripletWithSmallerSum2 {

    /**
     * Another simpler approach could be to check every triplet of the array with three nested loops
     * and create a list of triplets that meet the required condition.
     *
     * Time complexity
     * Sorting the array will take O(N∗logN).
     * The searchPair(), in this case, will take O(N^2);
     * the main while loop will run in O(N)
     * but the nested for loop can also take O(N) - this will happen when the target sum is bigger than every triplet in the array.
     *
     * So, overall searchTriplets() will take O(N * logN + N^3), which is asymptotically equivalent to O(N^3).
     *
     * Space complexity
     * Ignoring the space required for the output array,
     * the space complexity of the above algorithm will be O(N) which is required for sorting.
     */
    public static List<List<Integer>> searchTriplets(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            searchPair(arr, target - arr[i], i, triplets);
        }
        return triplets;
    }

    private static void searchPair(int[] arr, int targetSum, int first, List<List<Integer>> triplets) {
        int left = first + 1, right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] < targetSum) { // found the triplet
                // since arr[right] >= arr[left], therefore, we can replace arr[right] by any number between
                // left and right to get a sum less than the target sum
                for (int i = right; i > left; i--)
                    triplets.add(Arrays.asList(arr[first], arr[left], arr[i]));
                left++;
            } else {
                right--; // we need a pair with a smaller sum
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(TripletWithSmallerSum2.searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
        System.out.println(TripletWithSmallerSum2.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
    }
}