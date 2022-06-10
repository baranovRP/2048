package lc;

import java.util.Arrays;

public class RichestCustomerWealth {

    // Time = O(M*N)
    // Space = O(1)
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            int current = 0;
            for (int i : account) {
                current += i;
            }
            max = Math.max(max, current);
        }
        return max;
    }

    public int maximumWealth1(int[][] accounts) {
        return Arrays.stream(accounts).mapToInt(i -> Arrays.stream(i).sum()).max().getAsInt();
    }
}
