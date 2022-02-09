package ds.array;

public class CheckRemoveEven {

    /**
     * Time Complexity
     * Since the entire array has to be iterated over, this solution is in O(n).
     * <p>
     * Space Complexity
     * O(n)
     */
    public static int[] removeEven(int[] arr) {
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                arr[start] = arr[i];
                start++;
            }
        }
        int[] res = new int[start];
        for (int i = 0; i < res.length; i++) res[i] = arr[i];
        return res; // change this and return the correct result array
    }

    public static void main(String args[]) {

        int size = 10;
        int[] arr = new int[size]; //declaration and instantiation

        System.out.print("Before removing Even Numbers: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i; // assigning values
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int[] newArr = removeEven(arr); // calling removeEven

        System.out.print("After removing Even Numbers: ");
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + " "); // prinitng array
        }
    }
}
