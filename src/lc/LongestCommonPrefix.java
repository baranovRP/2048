package lc;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1 || strs[0].length() == 0) return strs[0];
        String init = strs[0];
        int lastIdx = init.length() - 1;
        for (int j = 1; j < strs.length; j++) {
            String str = strs[j];
            lastIdx = Math.min(lastIdx, str.length() - 1);
            for (int i = 0; i <= lastIdx; i++) {
                if (init.charAt(i) != str.charAt(i)) {
                    if (i == 0) return "";
                    else {
                        lastIdx = i - 1;
                        break;
                    }
                }
            }
        }
        return init.substring(0, lastIdx + 1);
    }

    // Time = O(S), where S is the sum of all characters in all strings.
    // Space = O(1)
    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix prefix = new LongestCommonPrefix();
        System.out.println(prefix.longestCommonPrefix1(new String[]{"flower", "flow", "flight"}));
        System.out.println(prefix.longestCommonPrefix(new String[]{"", "b"}));
        System.out.println(prefix.longestCommonPrefix(new String[]{"ab", "a"}));
        System.out.println(prefix.longestCommonPrefix(new String[]{"a", "ac"}));
        System.out.println(prefix.longestCommonPrefix(new String[]{"a", "b"}));
    }
}
