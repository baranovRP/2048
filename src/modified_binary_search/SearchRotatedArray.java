package modified_binary_search;

public class SearchRotatedArray {

    /**
     * Time complexity
     * Since we are reducing the search range by half at every step,
     * this means that the time complexity of our algorithm will be O(logN)
     * where ‘N’ is the total elements in the given array.
     * <p>
     * Space complexity
     * The algorithm runs in constant space O(1).
     */
    public static int search(int[] arr, int key) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) return mid;

            if (arr[start] <= arr[mid]) {
                if (arr[start] <= key && key < arr[mid]) {
                    end = mid - 1;
                } else start = mid + 1;
            } else {
                if (arr[mid] < key && key <= arr[end]) {
                    start = start + 1;
                } else end = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(SearchRotatedArray.search(new int[]{10, 15, 1, 3, 8}, 15));
        System.out.println(SearchRotatedArray.search(new int[]{4, 5, 7, 9, 10, -1, 2}, 10));
    }
}
