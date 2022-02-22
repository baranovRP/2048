package k_way_merge;

import java.util.*;

class NodeM {
    int row;
    int col;

    NodeM(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class KthSmallestInSortedMatrix {

    /**
     * Time complexity
     * First, we inserted at most ‘K’ or one element from each of the ‘N’ rows,
     * which will take O(min(K,N)).
     * Then we went through at most ‘K’ elements in the matrix
     * and remove/add one element in the heap in each step.
     * As we can’t have more than ‘N’ elements in the heap in any condition,
     * therefore, the overall time complexity of the above algorithm will be O(min(K,N)+K∗logN).
     *
     * Space complexity
     * The space complexity will be O(N) because,
     * in the worst case, our min-heap will be storing one number from each of the ‘N’ rows.
     */
    public static int findKthSmallest(int[][] matrix, int k) {
        PriorityQueue<NodeM> minHeap = new PriorityQueue<NodeM>((n1, n2) -> matrix[n1.row][n1.col] - matrix[n2.row][n2.col]);

        // put the 1st element of each row in the min heap
        // we don't need to push more than 'k' elements in the heap
        for (int i = 0; i < matrix.length && i < k; i++)
            minHeap.add(new NodeM(i, 0));

        // take the smallest (top) element form the min heap, if the running count is equal to k return the number
        // if the row of the top element has more elements, add the next element to the heap
        int numberCount = 0, result = 0;
        while (!minHeap.isEmpty()) {
            NodeM node = minHeap.poll();
            result = matrix[node.row][node.col];
            if (++numberCount == k)
                break;
            node.col++;
            if (matrix[0].length > node.col)
                minHeap.add(node);
        }
        return result;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
        int result = KthSmallestInSortedMatrix.findKthSmallest(matrix, 5);
        System.out.print("Kth smallest number is: " + result);
    }
}
