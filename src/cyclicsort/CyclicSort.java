package cyclicsort;

class CyclicSort {

    public static void sort(int[] nums) {
        for (int i=0;i<nums.length;i++){
            int digit = nums[i];
            if(digit!=i+1){
                int temp = nums[digit-1];
                nums[digit-1]=nums[i];
                nums[i]=temp;
                i--;
            }
        }
    }

    /**
     * Time complexity
     * The time complexity of the algorithm is O(n).
     * Although we are not incrementing the index i when swapping the numbers,
     * this will result in more than n iterations of the loop,
     * but in the worst-case scenario,
     * the while loop will swap a total of n-1 numbers, and once a number is at its correct index,
     * we will move on to the next number by incrementing i.
     * So overall, our algorithm will take O(n)+O(n−1) which is asymptotically equivalent to O(n).
     *
     * Space complexity
     * The algorithm runs in constant space O(1).
     */
    public static void sort2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1;
            if (nums[i] != nums[j])
                swap(nums, i, j);
            else
                i++;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 1, 5, 4, 2 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 2, 6, 4, 3, 1, 5 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 1, 5, 6, 4, 3, 2 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }
}

