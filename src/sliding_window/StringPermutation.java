package sliding_window;

import java.util.HashMap;
import java.util.Map;

class StringPermutation {
    public static boolean findPermutation(String str, String pattern) {
        int patternHash = 0;
        for (int i = 0; i < pattern.length(); i++) {
            patternHash += pattern.charAt(i);
        }

        int windowStart = 0;
        int currentHash = 0;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            currentHash += str.charAt(windowEnd);
            if (windowEnd - windowStart + 1 >= pattern.length()) {
                if (patternHash != currentHash) {
                    currentHash -= str.charAt(windowStart);
                    windowStart++;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Time Complexity
     * Algorithm’s time complexity will be O(N+M),
     * where ‘N’ and ‘M’ are the number of characters in the input string and the pattern, respectively.
     * <p>
     * Space Complexity
     * The algorithm’s space complexity is O(M) since, in the worst case,
     * the whole pattern can have distinct characters that will go into the HashMap.
     */
    public static boolean findPermutation2(String str, String pattern) {
        int windowStart = 0, matched = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : pattern.toCharArray())
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);

        // our goal is to match all the characters from the 'charFrequencyMap' with the current window
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (charFrequencyMap.containsKey(rightChar)) {
                // decrement the frequency of the matched character
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) == 0) // character is completely matched
                    matched++;
            }

            if (matched == charFrequencyMap.size())
                return true;

            if (windowEnd >= pattern.length() - 1) { // shrink the window by one character
                char leftChar = str.charAt(windowStart++);
                if (charFrequencyMap.containsKey(leftChar)) {
                    if (charFrequencyMap.get(leftChar) == 0)
                        matched--; // before putting the character back, decrement the matched count
                    // put the character back for matching
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("pattern: abc, str: oidbcaf,\nresult: " + findPermutation("oidbcaf", "abc"));
        System.out.println("pattern: dc, str: odicf,\nresult: " + findPermutation("odicf", "dc"));
        System.out.println("pattern: bcdyabcdx, str: bcdxabcdy,\nresult: " + findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println("pattern: abc, str: aaacb,\nresult: " + findPermutation("aaacb", "abc"));
        System.out.println("pattern: abc, str: aaacb,\nresult: " + findPermutation2("aaacb", "abc"));
    }
}

