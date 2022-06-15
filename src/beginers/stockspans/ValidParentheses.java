package beginers.stockspans;

import java.util.Stack;

public class ValidParentheses {

    // Time = O(N)
    // Space = O(N)
    public boolean isValid(String s) {
        Stack<Character> parentheses = new Stack<>();
        for (Character character : s.toCharArray()) {
            if (character == '(' || character == '[' || character == '{') {
                parentheses.push(character);
            } else {
                if (parentheses.isEmpty()) return false;
                if (!isValid(character, parentheses.pop())) return false;
            }
        }
        return parentheses.empty();
    }

    private boolean isValid(Character symb, Character parenthesis) {
        boolean isValid = false;
        switch (symb) {
            case ')':
                isValid = parenthesis == '(';
                break;
            case ']':
                isValid = parenthesis == '[';
                break;
            case '}':
                isValid = parenthesis == '{';
                break;
            default:
        }
        return isValid;
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid("]"));
    }
}
