package k_els;

import java.util.*;

class KthSmallestNumber {

    public static int findKthSmallestNumber(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);
        for (int i = 0; i < k; i++) maxHeap.add(nums[i]);

        for (int i = k; i < nums.length; i++) {
            if (maxHeap.peek() > nums[i]) {
                maxHeap.poll();
                maxHeap.add(nums[i]);
            }
        }

        return maxHeap.poll();
    }

    /**
     * Time complexity
     * The time complexity of this algorithm is O(K∗logK+(N−K)∗logK),
     * which is asymptotically equal to O(N∗logK)
     * <p>
     * Space complexity
     * The space complexity will be O(K) because we need to store ‘K’ smallest numbers in the heap.
     */
    public static int findKthSmallestNumber2(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);
        // put first k numbers in the max heap
        for (int i = 0; i < k; i++)
            maxHeap.add(nums[i]);

        // go through the remaining numbers of the array, if the number from the array is smaller than the
        // top (biggest) number of the heap, remove the top number from heap and add the number from array
        for (int i = k; i < nums.length; i++) {
            if (nums[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(nums[i]);
            }
        }

        // the root of the heap has the Kth smallest number
        return maxHeap.peek();
    }

    /**
     * Initializing the min-heap with all numbers will take O(N)
     * and extracting ‘K’ numbers will take O(KlogN).
     * Overall, the time complexity of this algorithm will be O(N+KlogN)
     * and the space complexity will be O(N).
     */
    public static int findKthSmallestNumberAlternativeApproach(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for (int i = 0; i < nums.length; i++) minHeap.add(nums[i]);
        int res = 0;
        for (int i = 0; i < k; i++) res = minHeap.poll();

        return res;
    }

    public static void main(String[] args) {
        int result = KthSmallestNumber.findKthSmallestNumber2(new int[]{1, 5, 12, 2, 11, 5}, 3);
        System.out.println("Kth smallest number is: " + result);

        // since there are two 5s in the input array, our 3rd and 4th smallest numbers should be a '5'
        result = KthSmallestNumber.findKthSmallestNumber2(new int[]{1, 5, 12, 2, 11, 5}, 4);
        System.out.println("Kth smallest number is: " + result);

        result = KthSmallestNumber.findKthSmallestNumber2(new int[]{5, 12, 11, -1, 12}, 3);
        System.out.println("Kth smallest number is: " + result);
    }
}
