package lc;

public class LengthLastWord {

    // Time = O(N)
    // Space = O(1)
    public int lengthOfLastWord(String s) {
        int counter = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char symb = s.charAt(i);
            if (symb == ' ' && counter > 0) return counter;
            if (symb != ' ') counter++;
        }
        return counter;
    }

    public int lengthOfLastWord1(String s) {
        int p = s.length(), length = 0;
        while (p > 0) {
            p--;
            // we're in the middle of the last word
            if (s.charAt(p) != ' ') {
                length++;
            }
            // here is the end of last word
            else if (length > 0) {
                return length;
            }
        }
        return length;
    }

    // Time = O(N)
    // Space = O(N)
    // In the Java implementation, we used the function String.trim()
    // which returns a copy of the input string without leading and trailing whitespace.
    // Therefore, we would need O(N) space for our algorithm to hold this copy.
    public int lengthOfLastWord2(String s) {
        s = s.trim();  // trim the trailing spaces in the string
        return s.length() - s.lastIndexOf(" ") - 1;
    }

    public static void main(String[] args) {
        LengthLastWord llw = new LengthLastWord();
        System.out.println(llw.lengthOfLastWord2("Hello World  "));
    }
}
