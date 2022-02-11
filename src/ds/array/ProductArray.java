package ds.array;

class ProductArray {
    public static int[] findProduct(int arr[]) {
        boolean isContainNull = false;
        int product = 1;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] != 0) {
                product *= arr[i];
            } else {
                isContainNull = true;
            }

        for (int i = 0; i < arr.length; i++)
            if (!isContainNull)
                arr[i] = product / arr[i];
            else
                arr[i] = (arr[i] == 0) ? product : 0;
        return arr;
    }

    /**
     * Time & Space Complexity
     * Time Complexity O(n)
     * Space Complexity O(n)
     * Auxiliary Space Used O(1)
     */
    public static int[] findProduct2(int arr[]) {
        int n = arr.length;
        int i, temp = 1;

        // Allocation of result array
        int result[] = new int[n];

        // Product of elements on left side excluding arr[i]
        for (i = 0; i < n; i++) {
            result[i] = temp;
            temp *= arr[i];
        }

        // Initializing temp to 1 for product on right side
        temp = 1;

        // Product of elements on right side excluding arr[i]
        for (i = n - 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= arr[i];
        }

        return result;
    }

    public static String arrayToString(int arr[]) {
        if (arr.length > 0) {
            String result = "";
            for (int i = 0; i < arr.length; i++) {
                result += arr[i] + " ";
            }
            return result;
        } else {
            return "Empty Array!";
        }
    }

    public static void main(String args[]) {

        int[] arr = {-1, 2, -3, 4, -5};

        System.out.println("Array before product: " + arrayToString(arr));

        int[] prodArray = findProduct2(arr);

//        System.out.println("Array after product: " + arrayToString(prodArray));
    }
}
