package two_pointers;

public class BackspaceCompare {

    public static boolean compare(String str1, String str2) {
        char backspace = '#';
        int i = str1.length() - 1, j = str2.length() - 1;
        while (j >= 0 || i >= 0) {
            int p1 = 0, p2 = 0;
            while (str1.charAt(i) == backspace && i-- > 0) {
                p1++;
            }
            while (str2.charAt(j) == backspace && j-- > 0) {
                p2++;
            }
            i = i - p1;
            j = j - p2;
            if (str1.charAt(i) != str2.charAt(j)) return false;
            if ((j == 0 || i == 0) && i != j) return false;
            if (j == 0 && i == 0) return true;

            i--;
            j--;
        }
        return false;
    }

    /**
     * Time complexity
     * The time complexity of the above algorithm will be O(M+N)
     * where ‘M’ and ‘N’ are the lengths of the two input strings respectively.
     * <p>
     * Space complexity
     * The algorithm runs in constant space O(1).
     */
    public static boolean compare2(String str1, String str2) {
        // use two pointer approach to compare the strings
        int index1 = str1.length() - 1, index2 = str2.length() - 1;
        while (index1 >= 0 || index2 >= 0) {

            int i1 = getNextValidCharIndex(str1, index1);
            int i2 = getNextValidCharIndex(str2, index2);

            if (i1 < 0 && i2 < 0) // reached the end of both the strings
                return true;

            if (i1 < 0 || i2 < 0) // reached the end of one of the strings
                return false;

            if (str1.charAt(i1) != str2.charAt(i2)) // check if the characters are equal
                return false;

            index1 = i1 - 1;
            index2 = i2 - 1;
        }

        return true;
    }

    private static int getNextValidCharIndex(String str, int index) {
        int backspaceCount = 0;
        while (index >= 0) {
            if (str.charAt(index) == '#') // found a backspace character
                backspaceCount++;
            else if (backspaceCount > 0) // a non-backspace character
                backspaceCount--;
            else
                break;

            index--; // skip a backspace or a valid character
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(BackspaceCompare.compare2("xy#z", "xzz#") + " == true");
        System.out.println(BackspaceCompare.compare("xp#", "xyz##") + " == true");
        System.out.println(BackspaceCompare.compare("xywrrmp", "xywrrmu#p") + " == true");
        System.out.println(BackspaceCompare.compare("xy#z", "xyz#") + " == false");
    }
}
