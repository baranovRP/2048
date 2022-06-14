package beginers.stockspans;

import java.util.Arrays;
import java.util.Stack;

public class SimpleStockSpan {

    // Time = O(n^2)
    // Space = O(n)
    public int[] simpleStockSpan(int[] quotes) {
        int[] spans = new int[quotes.length];
        spans[0] = 1;
        for (int i = 1; i < quotes.length; i++) {
            boolean endOfSpan = false;
            int k = 1;

            while (i - k >= 0 && !endOfSpan) {
                if (quotes[i - k] <= quotes[i]) {
                    k++;
                } else {
                    endOfSpan = true;
                }
            }
            spans[i] = k;
        }
        return spans;
    }

    public int[] simpleStockSpanWithStack(int[] quotes) {
        int[] spans = new int[quotes.length];
        Stack<Integer> stack = new Stack<>();
        spans[0] = 1;
        stack.push(0);
        for (int i = 1; i < quotes.length; i++) {
            while (!stack.empty() && quotes[stack.peek()] <= quotes[i]) {
                stack.pop();
            }
            if (stack.empty()) {
                spans[i] = i + 1;
            } else {
                spans[i] = i - stack.peek();
            }
            stack.push(i);
        }
        return spans;
    }

    public static void main(String[] args) {
        SimpleStockSpan sss = new SimpleStockSpan();
//        System.out.println(Arrays.toString(sss.simpleStockSpan(new int[]{2, 8, 5, 4, 3, 5, 7})));
        System.out.println(Arrays.toString(sss.simpleStockSpanWithStack(new int[]{2, 8, 5, 4, 3, 5, 7})));
    }
}
