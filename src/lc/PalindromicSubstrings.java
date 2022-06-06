package lc;

public class PalindromicSubstrings {

    // Time = O(N^3)
    // Space = O(1)
    public int countSubstrings(String s) {
        int counter=0;
        int start;
        for(int i=0;i<s.length();i++){
            start=i;
            while(start<s.length()){
                boolean checkPanlindrome = isPalindrome(s.substring(i,start+1));
                if(checkPanlindrome) counter++;
                start++;
            }
        }
        return counter;
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    // Time = O(N^2)
    // Space = O(1)
    // Expand Around Possible Centers
    public int countSubstrings1(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); ++i) {
            // odd-length palindromes, single character center
            ans += countPalindromesAroundCenter(s, i, i);

            // even-length palindromes, consecutive characters center
            ans += countPalindromesAroundCenter(s, i, i + 1);
        }

        return ans;
    }

    private int countPalindromesAroundCenter(String ss, int lo, int hi) {
        int ans = 0;

        while (lo >= 0 && hi < ss.length()) {
            if (ss.charAt(lo) != ss.charAt(hi))
                break;      // the first and last characters don't match!

            // expand around the center
            lo--;
            hi++;

            ans++;
        }

        return ans;
    }
}
