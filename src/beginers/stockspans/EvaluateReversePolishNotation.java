package beginers.stockspans;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    // Time = O(N)
    // Space = O(N)
    public int evalRPN(String[] tokens) {
        Stack<Integer> digits = new Stack<>();
        for (String token : tokens) {
            if (!isOperation(token)) {
                digits.push(Integer.valueOf(token));
            } else {
                Integer first = digits.pop();
                Integer second = digits.pop();
                switch (token) {
                    case "+":
                        digits.push(second + first);
                        break;
                    case "-":
                        digits.push(second - first);
                        break;
                    case "*":
                        digits.push(second * first);
                        break;
                    case "/":
                        digits.push((Integer) (second / first));
                        break;
                }
            }
        }
        return digits.pop();
    }

    private boolean isOperation(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }


    public int evalRPN1(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            if (!"+-*/".contains(token)) {
                stack.push(Integer.valueOf(token));
                continue;
            }

            int number2 = stack.pop();
            int number1 = stack.pop();

            int result = 0;

            switch (token) {
                case "+":
                    result = number1 + number2;
                    break;
                case "-":
                    result = number1 - number2;
                    break;
                case "*":
                    result = number1 * number2;
                    break;
                case "/":
                    result = number1 / number2;
                    break;
            }

            stack.push(result);

        }

        return stack.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation rpn = new EvaluateReversePolishNotation();
        System.out.println(rpn.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(rpn.evalRPN(new String[]{"2", "1", "+", "3", "*", "3", "/"}));
    }
}
