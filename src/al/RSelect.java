package al;

import java.util.Arrays;
import java.util.Random;

public class RSelect {

    public int rSelect(int[] nums, int n) {
        if (nums == null) throw new IllegalArgumentException();

        return rSelectHelper(nums, n, 0, nums.length - 1);
    }

    private int rSelectHelper(int[] arr, int k, int leftIdx, int rightIdx) {
        if (leftIdx == rightIdx) return arr[leftIdx];

        int pivotIdx = choosePivot(leftIdx, rightIdx);
        swap(arr, pivotIdx, leftIdx);
        int outBorder = partition(arr, leftIdx, rightIdx);
        if (k==outBorder) return arr[outBorder];
        else if (k < outBorder) return rSelectHelper(arr, leftIdx, outBorder - 1, k);
        else return rSelectHelper(arr, outBorder + 1, rightIdx, k);
    }

    private int partition(int[] arr, int leftIdx, int rightIdx) {
        int pivot = arr[leftIdx];
        int innerBorder = leftIdx + 1;
        for (int outBorder = leftIdx + 1; outBorder <= rightIdx; outBorder++) {
            if (arr[outBorder] < pivot) {
                swap(arr, outBorder, innerBorder++);
            }
        }
        swap(arr, leftIdx, innerBorder - 1);
        return innerBorder - 1;
    }

    private int choosePivot(int leftIdx, int rightIdx) {
        Random rand = new Random();
        return rand.nextInt(rightIdx + 1 - leftIdx) + leftIdx;
    }

    private void swap(int[] nums, int n1, int n2) {
        if (n1 != n2) {
            int tmp = nums[n1];
            nums[n1] = nums[n2];
            nums[n2] = tmp;
        }
    }

    public static void main(String[] args) {
        RSelect rs = new RSelect();
        System.out.println("([1, 2, 3, 4, 5, 6, 7, 8], 4) 5 == \n" + rs.rSelect(new int[]{5, 4, 1, 8, 7, 2, 6, 3}, 4));
        System.out.println("([1, 2, 3, 4, 5, 6, 7, 8, 15], 4) 6 == \n" + rs.rSelect(new int[]{5, 15, 4, 1, 8, 7, 2, 6, 3}, 4));
//        System.out.println("[] == \n" + rs.rSelect(new int[]{}, 2));
//        System.out.println("[1] == \n" + rs.rSelect(new int[]{1}, 1));
//        System.out.println("[1, 2, 2, 2, 2] == \n" + rs.rSelect(new int[]{2, 2, 2, 1, 2}, 3));
    }

}
