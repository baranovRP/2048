package ds.stack_queue;

import java.util.Arrays;

public class NextGreaterElementUsingStack {

    /**
     * Time Complexity
     * In the above algorithm, it is observed that every element is pushed on the stack exactly once.
     * Furthermore, since once an element is removed from the stack,
     * it is never re-inserted, every element is removed exactly once, too.
     * That means we perform one push and one pop operation per element, exactly.
     * Therefore, the time complexity of this algorithm will be O(n).
     * This is a significant improvement over the brute force method’s runtime complexity of O(n^2).
     */
    public static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>(arr.length);
        // iterate for rest of the elements
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.top() <= arr[i]) {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else
                result[i] = stack.top();
            stack.push(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {4, 6, 3, 2, 8, 1, 11};
//        int arr[] = {1,2,3,4,5};
        System.out.println(Arrays.toString(arr));
        int result[] = nextGreaterElement(arr);
        System.out.println(Arrays.toString(result));
    }

}
