public class RemoveElement {
    public int removeElement( int[] nums, int val ) {
        int empties = 0;
        for ( int i = 0, j = 0; j < nums.length; i++, j++ ) {
            if ( nums[ j ] == val ) {
                do {
                    j++;
                    empties++;
                } while ( j < nums.length && nums[ j ] == val );
            }
            if ( j < nums.length ) {
                nums[ i ] = nums[ j ];
            }
        }
        return nums.length - empties;
    }

//    Complexity analysis
//
//    Time complexity : O(n). Assume the array has a total of nnn elements, both iii and jjj traverse at most 2n2n2n steps.
//
//    Space complexity : O(1).

    public int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

//    Complexity analysis

//    Time complexity : O(n). Both i and n traverse at most n steps. In this approach,
//    the number of assignment operations is equal to the number of elements to remove.
//    So it is more efficient if elements to remove are rare.
//
//    Space complexity : O(1).

    public int removeElement3(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}
