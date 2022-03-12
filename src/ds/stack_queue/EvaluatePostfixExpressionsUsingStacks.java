package ds.stack_queue;

public class EvaluatePostfixExpressionsUsingStacks {

    /**
     * Time Complexity
     * Since we traverse the string of n characters once,
     * the time complexity for this algorithm is O(n).
     */
    public static int evaluatePostFix(String expression) {
        Stack<Integer> stack = new Stack<>(expression.length());
        //1.Scan expression character by character,
        //2.If character is a number push it in stack
        //3.If character is operator then pop two elements from stack
        //perform the operation and put the result back in stack
        //At the end, Stack will contain result of whole expression.
        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);

            if (!Character.isDigit(character)) {
                Integer x = stack.pop();
                Integer y = stack.pop();

                switch (character) {
                    case '+':
                        stack.push(y + x);
                        break;
                    case '-':
                        stack.push(y - x);
                        break;
                    case '*':
                        stack.push(y * x);
                        break;
                    case '/':
                        stack.push(y / x);
                        break;
                }

            } else
                stack.push(Character.getNumericValue(character));
        }
        return stack.pop();
    }

    public static void main(String args[]) {

        System.out.println(evaluatePostFix("921*-8-4+"));
    }
}
