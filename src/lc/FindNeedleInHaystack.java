package lc;

public class FindNeedleInHaystack {

    // Time = O(m*n)
    // Space = O(1)
    public int strStr(String haystack, String needle) {
        int end = haystack.length();
        int p1 = 0, p2 = 0, idx = 0;
        if (needle.equals("")) return 0;
        while (p2 < end) {
            if (haystack.charAt(p2) != needle.charAt(idx)) {
                p1++;
                p2 = p1;
                idx = 0;
            } else if (idx == needle.length() - 1) return p1;
            else {
                p2++;
                idx++;
            }
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        int end = haystack.length();
        int p1 = 0, p2 = needle.length();
        if (needle.equals("")) return 0;
        while (p2 <= end) {
            if (!haystack.substring(p1, p2).equals(needle)) {
                p1++;
                p2++;
            } else {
                return p1;
            }
        }
        return -1;
    }

    // Time = O(m+n)
    // Space = O(m)
    // More detail about KMP: https://en.wikipedia.org/wiki/Knuth–Morris–Pratt_algorithm
    public int strStr3(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        int[] lps = computeKMPTable(needle);
        int i = 0, j = 0, n = haystack.length(), m = needle.length();
        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                ++i;
                ++j;
                if (j == m) return i - m; // found solution
            } else {
                if (j != 0) j = lps[j - 1]; // try match with longest prefix suffix
                else i++; // don't match -> go to next character of `haystack` string
            }
        }
        return -1;
    }

    private int[] computeKMPTable(String pattern) {
        int i = 1, j = 0, n = pattern.length();
        int[] lps = new int[n];
        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                lps[i++] = ++j;
            } else {
                if (j != 0) j = lps[j - 1]; // try match with longest prefix suffix
                else i++; // don't match -> go to next character
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        FindNeedleInHaystack fn = new FindNeedleInHaystack();
//        System.out.println(fn.strStr2("mississippi", "issip"));
        System.out.println(fn.strStr2("abc", "c"));
    }
}
