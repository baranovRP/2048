package ds.array;

public class CheckRotateArray {

    public static void rotateArray(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            temp = arr[(i + 1) % arr.length];
            arr[(i + 1) % arr.length] = arr[0];
            arr[0] = temp;
        }
    }

    /**
     * Time Complexity
     * Since the entire array is iterated over once,
     * the time complexity of this solution is O(n).
     */
    //Rotates given Array by 1 position
    public static void rotateArray2(int[] arr) {

        //Store last element of Array.
        //Start from the Second last and Right Shift the Array by one.
        //Store the last element saved on the first index of the Array.
        int lastElement = arr[arr.length - 1];

        for (int i = arr.length - 1; i > 0; i--) {

            arr[i] = arr[i - 1];
        }

        arr[0] = lastElement;
    } //end of rotateArray

    public static void main(String args[]) {

        int[] arr = {3, 6, 1, 8, 4, 2};

        System.out.print("Array before rotation: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        rotateArray(arr);

        System.out.print("Array after rotation: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
