package ds.array;

import java.util.*;

class CheckSum {

    /**
     * Since we iterate over the entire array in a nested loop, the time complexity is O(n^2).
     */
    public static int[] findSumBrutForce(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (n - arr[i] - arr[j] == 0) {
                    return new int[]{arr[i], arr[j]};
                }
            }
        }
        return arr;   // return the elements in the array whose sum is equal to the value passed as parameter
    }

    /**
     * Time Complexity
     * Since the sorting function used in this code takes O(nlogn)
     * and the algorithm to find two numbers takes O(n) time,
     * the overall time complexity of this code is O(nlogn).
     */
    public static int[] findSum(int[] arr, int n) {
        Arrays.sort(arr);
        int start = 0, end = arr.length - 1;
        while (start < end) {
            if (n == arr[start] + arr[end]) return new int[]{arr[start], arr[end]};
            if (n - arr[end] > arr[start]) start++;
            else end--;
        }
        return arr;   // return the elements in the array whose sum is equal to the value passed as parameter
    }

    public static void main(String args[]) {

        checkSolution(9, new int[]{2, 4, 5, 7, 8});
        checkSolution(27, new int[]{1, 21, 3, 14, 5, 60, 7, 6});
        checkSolution(17, new int[]{9, 4, 7, 2, 6});
    }

    private static void checkSolution(int n, int[] arr1) {
        if (arr1.length > 0) {
            int[] arr2 = findSum(arr1, n);
            int num1 = arr2[0];
            int num2 = arr2[1];

            if ((num1 + num2) != n)
                System.out.println("Not Found");
            else {
                System.out.println("Number 1 = " + num1);
                System.out.println("Number 2 = " + num2);
                System.out.println("Sum = " + n);

            }
        } else {
            System.out.println("Input Array is Empty!");
        }
    }
}
