package al;

import java.util.Arrays;
import java.util.Random;

public class QuickSortTest2 {

    public int[] quickSort(int[] arr) {
        if (arr == null) throw new IllegalArgumentException();
        quickSortHelper(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSortHelper(int[] arr, int leftIdx, int rightIdx) {
        if(leftIdx >=rightIdx) return;
        int pivot = choosePivot(leftIdx, rightIdx);
        swap(arr, leftIdx, pivot);
        int outBorder = partition(arr, leftIdx, rightIdx);
        quickSortHelper(arr, leftIdx, outBorder-1);
        quickSortHelper(arr, outBorder+1, rightIdx);
    }

    private int partition(int[] arr, int leftIdx, int rightIdx) {
        int pivot = arr[leftIdx];
        int innerBorder = leftIdx + 1;
        for (int outerBorder = leftIdx + 1; outerBorder <= rightIdx; outerBorder++) {
            if (arr[outerBorder] < pivot) {
                swap(arr, outerBorder, innerBorder++);
            }
        }
        swap(arr, leftIdx, innerBorder - 1);
        return innerBorder - 1;
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
        QuickSortTest2 qst = new QuickSortTest2();
        System.out.println("[1, 2, 3, 4, 5, 6, 7, 8] == \n" + Arrays.toString(qst.quickSort(new int[]{5, 4, 1, 8, 7, 2, 6, 3})));
        System.out.println("[] == \n" + Arrays.toString(qst.quickSort(new int[]{})));
        System.out.println("[1] == \n" + Arrays.toString(qst.quickSort(new int[]{1})));
        System.out.println("[1, 2, 2, 2, 2] == \n" + Arrays.toString(qst.quickSort(new int[]{2, 2, 2, 1, 2})));
    }
}
