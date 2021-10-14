package sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * Time Complexity#
 * The above algorithm’s time complexity will be O(N), where N is the number of characters in the input string.
 * The outer for loop runs for all characters, and the inner while loop processes each character only once;
 * therefore, the time complexity of the algorithm will be O(N+N), which is asymptotically equivalent to O(N).
 *
 * Space Complexity
 * The algorithm’s space complexity is O(K), as we will be storing a maximum of K+1 characters in the HashMap.
 */
class LongestSubstringKDistinct {

    public static int findLength(String str, int k) {
        Map<Character, Integer> chars = new HashMap<>();
        int max = 0;
        int currentMax = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char ch = str.charAt(windowEnd);
            int value = chars.get(ch) == null ? 0 : chars.get(ch);
            chars.put(ch, value + 1);
            currentMax++;
            while (chars.size() > k) {
                char ch2 = str.charAt(windowStart);
                int value2 = chars.get(ch2) - 1;
                chars.put(ch2, value2);
                if (value2 == 0) {
                    chars.remove(ch2);
                }
                currentMax--;
                windowStart++;
            }
            max = Math.max(max, currentMax);
        }
        return max;
    }

    public static int findLength2(String str, int k) {
        if (str == null || str.length() == 0)
            throw new IllegalArgumentException();

        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        // in the following loop we'll try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
            // shrink the sliding window, until we are left with 'k' distinct characters in the frequency map
            while (charFrequencyMap.size() > k) {
                char leftChar = str.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++; // shrink the window
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 10));
    }
}