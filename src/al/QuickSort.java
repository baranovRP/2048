package al;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public int[] quickSort(int[] arr) {
        if (arr == null) throw new IllegalArgumentException();
        quickSortHelper(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSortHelper(int[] arr, int leftIdx, int rightIdx) {
        if (leftIdx >= rightIdx) return;
        int lowBorder = choosePivot(leftIdx, rightIdx);
        swap(arr, leftIdx, lowBorder);
        int highBorder = partition(arr, leftIdx, rightIdx);
        quickSortHelper(arr, leftIdx, highBorder - 1);
        quickSortHelper(arr, highBorder + 1, rightIdx);
    }

    private int partition(int[] arr, int leftIdx, int rightIdx) {
        int partition = arr[leftIdx];
        int lowBorder = leftIdx + 1;
        for (int highBorder = leftIdx + 1; highBorder <= rightIdx; highBorder++) {
            if (arr[highBorder] < partition) {
                swap(arr, highBorder, lowBorder);
                lowBorder++;
            }
        }
        swap(arr, leftIdx, lowBorder - 1);
        return lowBorder - 1;
    }

    private int choosePivot(int leftIdx, int rightIdx) {
        Random rand = new Random();
        int random = rand.nextInt(rightIdx - leftIdx + 1);
        return random + leftIdx;
    }

    private void swap(int[] nums, int n1, int n2) {
        if (n1 != n2) {
            nums[n1] ^= nums[n2];
            nums[n2] = nums[n1] ^ nums[n2];
            nums[n1] = nums[n1] ^ nums[n2];
        }
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        System.out.println("[1, 2, 3, 4, 5, 6, 7, 8] == \n" + Arrays.toString(qs.quickSort(new int[]{5, 4, 1, 8, 7, 2, 6, 3})));
        System.out.println("[] == \n" + Arrays.toString(qs.quickSort(new int[]{})));
        System.out.println("[1] == \n" + Arrays.toString(qs.quickSort(new int[]{1})));
        System.out.println("[1, 2, 2, 2, 2] == \n" + Arrays.toString(qs.quickSort(new int[]{2, 2, 2, 1, 2})));
    }
}
