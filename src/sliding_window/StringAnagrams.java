package sliding_window;

import java.util.*;

class StringAnagrams {
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<>();
        Map<Character, Integer> frequencyMap = new HashMap<>();
        int windowStart = 0, matches = 0;
        for (int i = 0; i < pattern.length(); i++) {
            char symb = pattern.charAt(i);
            frequencyMap.put(symb, frequencyMap.getOrDefault(symb, 0) + 1);
        }
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char right = str.charAt(windowEnd);
            if (frequencyMap.containsKey(right)) {
                frequencyMap.put(right, frequencyMap.get(right) - 1);
                if (frequencyMap.get(right) == 0) {
                    matches++;
                }
            }
            if (matches == frequencyMap.size()) {
                resultIndices.add(windowEnd + 1 - pattern.length());
            }
            if (windowEnd >= pattern.length() - 1) {
                char left = str.charAt(windowStart);
                windowStart++;
                if (frequencyMap.get(left) == 0) {
                    matches--;
                    frequencyMap.put(left, frequencyMap.get(left) + 1);
                }
            }
        }
        return resultIndices;
    }

    /**
     * Time Complexity
     * The time complexity of the above algorithm will be O(N+M)
     * where ‘N’ and ‘M’ are the number of characters in the input string and the pattern respectively.
     * <p>
     * Space Complexity
     * The space complexity of the algorithm is O(M) since in the worst case,
     * the whole pattern can have distinct characters which will go into the HashMap.
     * In the worst case, we also need O(N) space for the result list,
     * this will happen when the pattern has only one character and the string contains only that character.
     */
    public static List<Integer> findStringAnagrams2(String str, String pattern) {
        int windowStart = 0, matched = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : pattern.toCharArray())
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);

        List<Integer> resultIndices = new ArrayList<Integer>();
        // our goal is to match all the characters from the map with the current window
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            // decrement the frequency of the matched character
            if (charFrequencyMap.containsKey(rightChar)) {
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) == 0)
                    matched++;
            }

            if (matched == charFrequencyMap.size()) // have we found an anagram?
                resultIndices.add(windowStart);

            if (windowEnd >= pattern.length() - 1) { // shrink the window
                char leftChar = str.charAt(windowStart++);
                if (charFrequencyMap.containsKey(leftChar)) {
                    if (charFrequencyMap.get(leftChar) == 0)
                        matched--; // before putting the character back, decrement the matched count
                    // put the character back
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }
            }
        }

        return resultIndices;
    }

    public static void main(String[] args) {
        System.out.println("String: ppqp, Pattern: pq. Result: "
                + findStringAnagrams2("ppqp", "pq")
                + "\nexpected: [1, 2]");
        System.out.println("String: abbcabc, Pattern: abc. Result: "
                + findStringAnagrams2("abbcabc", "abc")
                + "\nexpected: [2, 3, 4]");
    }
}

