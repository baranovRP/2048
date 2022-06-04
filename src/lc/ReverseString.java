package lc;

public class ReverseString {

    // Time = O(N)
    // Space = O(1)
    public void reverseString(char[] s) {
        int l=0,r=s.length-1;
        while(l<r){
            char t=s[r];
            s[r]=s[l];
            s[l]=t;
            r--;
            l++;
        }
    }
}
