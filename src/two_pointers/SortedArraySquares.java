package two_pointers;

class SortedArraySquares {

    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        for (int p1 = 0, p2 = arr.length - 1; p1 < p2; ) {
            int first = (int) Math.pow(arr[p1], 2);
            int second = (int) Math.pow(arr[p2], 2);
            if (first > second) {
                squares[p2 - p1] = first;
                p1++;
            } else {
                squares[p2 - p1] = second;
                p2--;
            }
        }
        return squares;
    }

    /**
     * Time complexity
     * The algorithm’s time complexity will be O(N) as we are iterating the input array only once.
     *
     * Space complexity
     * The above algorithm’s space complexity will also be O(N);
     * this space will be used for the output array.
     */
    public static int[] makeSquares2(int[] arr) {
        int n = arr.length;
        int[] squares = new int[n];
        int highestSquareIdx = n - 1;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];
            if (leftSquare > rightSquare) {
                squares[highestSquareIdx--] = leftSquare;
                left++;
            } else {
                squares[highestSquareIdx--] = rightSquare;
                right--;
            }
        }
        return squares;
    }

    public static void main(String[] args) {

        int[] result = SortedArraySquares.makeSquares(new int[]{-2, -1, 0, 2, 3});
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = SortedArraySquares.makeSquares(new int[]{-3, -1, 0, 1, 2});
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }
}