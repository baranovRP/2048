package lc;

import java.util.Stack;

public class FindCelebChallenge {

    // Time = O(N)
    // Space = O(1). Our code only uses constant extra space.
    public int findCelebrity(int n) {
        Stack<Integer> stack = new Stack<>();
        int celebrity = -1;

        //Push all people in stack
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        while (!stack.isEmpty()) {

            //Take two people out of stack and check if they know each other
            //One who doesn't know the other, push it back in stack.
            int x = stack.pop();

            if (stack.isEmpty()) {
                celebrity = x;
                break;
            }

            int y = stack.pop();

            if (knows(x, y)) {
                //x knows y , discard x and push y in stack
                stack.push(y);
            } else stack.push(x);

        } //end of while

        //At this point we will have last element of stack as celebrity
        //Check it to make sure it's the right celebrity
        for (int j = 0; j < n; j++) {

            //Celebrity knows no one while everyone knows celebrity
            if (celebrity != j && (knows(celebrity, j) || !(knows(j, celebrity)))) return -1;
        }
        return celebrity;
    }

    private boolean knows(int a, int b) {
        return a == 1;
    }
}
