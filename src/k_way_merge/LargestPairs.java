package k_way_merge;

import java.util.*;

class LargestPairs {

    /**
     * Time complexity
     * Since, at most, we’ll be going through all the elements of both arrays
     * and we will add/remove one element in the heap in each step,
     * the time complexity of the above algorithm will be O(N∗M∗logK)
     * where ‘N’ and ‘M’ are the total number of elements in both arrays, respectively.
     * <p>
     * If we assume that both arrays have at least ‘K’ elements
     * then the time complexity can be simplified to O(K^2logK),
     * because we are not iterating more than ‘K’ elements in both arrays.
     * <p>
     * Space complexity
     * The space complexity will be O(K) because,
     * at any time, our Min Heap will be storing ‘K’ largest pairs.
     */
    public static List<int[]> findKLargestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((p1, p2) -> (p1[0] + p1[1]) - (p2[0] + p2[1]));
        for (int i = 0; i < nums1.length && i < k; i++) {
            for (int j = 0; j < nums2.length && j < k; j++) {
                if (minHeap.size() < k) {
                    minHeap.add(new int[]{nums1[i], nums2[j]});
                } else {
                    // if the sum of the two numbers from the two arrays is smaller than the smallest (top) element of
                    // the heap, we can 'break' here. Since the arrays are sorted in the descending order, we'll not be
                    // able to find a pair with a higher sum moving forward.
                    if (nums1[i] + nums2[j] < minHeap.peek()[0] + minHeap.peek()[1]) {
                        break;
                    } else { // else: we have a pair with a larger sum, remove top and insert this pair in the heap
                        minHeap.poll();
                        minHeap.add(new int[]{nums1[i], nums2[j]});
                    }
                }
            }
        }
        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        int[] l1 = new int[]{9, 8, 2};
        int[] l2 = new int[]{6, 3, 1};
        List<int[]> result = LargestPairs.findKLargestPairs(l1, l2, 3);
        System.out.print("Pairs with largest sum are: ");
        for (int[] pair : result)
            System.out.print("[" + pair[0] + ", " + pair[1] + "] ");
    }
}

