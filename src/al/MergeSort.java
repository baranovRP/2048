package al;

import java.util.Arrays;

public class MergeSort {

    public int[] mergeSort(int[] arr) {
        if (arr.length <= 1) return arr;
        int[] half1 = new int[arr.length / 2];
        int[] half2 = new int[arr.length - arr.length / 2];
        int k = 0;
        for (; k < half1.length; k++) {
            half1[k] = arr[k];
        }
        for (int i = 0; i < half2.length; i++, k++) {
            half2[i] = arr[k];
        }
        return merge(mergeSort(half1), mergeSort(half2));
    }

    private int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0;
        for (int k = 0; k < result.length; k++) {
            if (i < arr1.length && j < arr2.length) {
                if (arr1[i] < arr2[j]) {
                    result[k] = arr1[i];
                    i++;
                } else {
                    result[k] = arr2[j];
                    j++;
                }
            } else if (i < arr1.length) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }
        }
        return result;
    }

    public int[] mergeSortRefactor(int[] arr) {
        if (arr.length <= 1) return arr;
        int[] right = Arrays.copyOf(arr, arr.length / 2);
        int[] left = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
        return mergeRefactor(mergeSort(right), mergeSort(left));
    }

    private int[] mergeRefactor(int[] arr1, int[] arr2) {
        int len1 = arr1.length, len2 = arr2.length, resLength = len1 + len2;
        int[] result = new int[resLength];
        int i1 = 0, i2 = 0;

        for (int k = 0; k < resLength; k++) {
            if (i1 == len1) {
                result[k] = arr2[i2++];
            } else if (i2 == len2) {
                result[k]=arr1[i1++];
            } else {
                if (arr1[i1] < arr2[i2]) {
                    result[k] = arr1[i1++];
                } else {
                    result[k] = arr2[i2++];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MergeSort mg = new MergeSort();
        System.out.println("[1, 2, 3, 4, 5, 6, 7, 8] == \n" + Arrays.toString(mg.mergeSort(new int[]{5, 4, 1, 8, 7, 2, 6, 3})));
        System.out.println("[1, 2, 3, 4, 5, 6, 7, 8] == \n" + Arrays.toString(mg.mergeSortRefactor(new int[]{5, 4, 1, 8, 7, 2, 6, 3})));
        System.out.println("[] == \n" + Arrays.toString(mg.mergeSortRefactor(new int[]{})));
        System.out.println("[1] == \n" + Arrays.toString(mg.mergeSortRefactor(new int[]{1})));
        System.out.println("[1, 2, 2, 2, 2] == \n" + Arrays.toString(mg.mergeSortRefactor(new int[]{2, 2, 2, 1, 2})));
    }

}

