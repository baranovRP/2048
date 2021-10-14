package sliding_window;


import java.util.HashMap;
import java.util.Map;

/**
 * Time Complexity#
 * The above algorithm’s time complexity will be O(N), where ‘N’ is the number of characters in the input array.
 * The outer for loop runs for all characters, and the inner while loop processes each character only once;
 * therefore, the time complexity of the algorithm will be O(N+N), which is asymptotically equivalent to O(N).
 *
 * Space Complexity
 * The algorithm runs in constant space O(1) as there can be a maximum of three types of fruits stored in the frequency map.
 */
class MaxFruitCountOf2Types {
    public static int findLength(char[] arr) {
        Map< Character, Integer > baskets = new HashMap<>();
        int maxFruits = 0;
        int windowStart = 0;
        for ( int windowEnd = 0; windowEnd < arr.length; windowEnd++ ) {
            baskets.put( arr[ windowEnd ], baskets.getOrDefault( arr[ windowEnd ], 0 ) + 1 );
            int BASKET = 2;
            while ( baskets.size() > BASKET ) {
                int val = baskets.get( arr[ windowStart ] ) - 1;
                baskets.put(arr[windowStart], val);
                if ( baskets.get( arr[ windowStart ]) == 0 ) {
                    baskets.remove( arr[ windowStart ] );
                }
                windowStart++;
            }
            maxFruits = Math.max( maxFruits, windowEnd - windowStart + 1 );
        }
        return maxFruits;
    }

    public static int findLength2(char[] arr) {
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> fruitFrequencyMap = new HashMap<>();
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            fruitFrequencyMap.put(arr[windowEnd], fruitFrequencyMap.getOrDefault(arr[windowEnd], 0) + 1);
            // shrink the sliding window, until we are left with '2' fruits in the frequency map
            while (fruitFrequencyMap.size() > 2) {
                fruitFrequencyMap.put(arr[windowStart], fruitFrequencyMap.get(arr[windowStart]) - 1);
                if (fruitFrequencyMap.get(arr[windowStart]) == 0) {
                    fruitFrequencyMap.remove(arr[windowStart]);
                }
                windowStart++; // shrink the window
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
    }
}
