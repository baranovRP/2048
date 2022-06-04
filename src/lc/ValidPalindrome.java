package lc;

public class ValidPalindrome {

    // Time = O(N)
    // Space = O(1)
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (!Character.isLetterOrDigit(s.charAt(l)) && l < r) l++;
            while (!Character.isLetterOrDigit(s.charAt(r)) && l < r) r--;
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) return false;
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(vp.isPalindrome("OP"));
        System.out.println(vp.isPalindrome("0P"));
    }
}
