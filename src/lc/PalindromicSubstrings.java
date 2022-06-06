package lc;

public class PalindromicSubstrings {

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

}
