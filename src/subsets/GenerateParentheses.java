package subsets;

import java.util.*;

class ParenthesesString {
    String str;
    int openCount; // open parentheses count
    int closeCount; // close parentheses count

    public ParenthesesString(String s, int openCount, int closeCount) {
        str = s;
        this.openCount = openCount;
        this.closeCount = closeCount;
    }
}

class GenerateParentheses {

    /**
     * Time complexity
     * Let’s try to estimate how many combinations we can have for ‘N’ pairs of balanced parentheses.
     * If we don’t care for the ordering - that ) can only come after ( - then we have two options for every position,
     * i.e., either put open parentheses or close parentheses. This means we can have a maximum of 2^N combinations.
     * Because of the ordering, the actual number will be less than 2^N.
     * <p>
     * If you see the visual representation of Example-2 closely you will realize that,
     * in the worst case, it is equivalent to a binary tree, where each node will have two children.
     * This means that we will have 2^N leaf nodes and 2^N-1 intermediate nodes.
     * So the total number of elements pushed to the queue will be 2^N + 2^N-1,
     * which is asymptotically equivalent to O(2^N).
     * While processing each element, we do need to concatenate the current string with ( or ).
     * This operation will take O(N), so the overall time complexity of our algorithm will be O(N*2^N).
     * This is not completely accurate but reasonable enough to be presented in the interview.
     * <p>
     * Space complexity
     * All the additional space used by our algorithm is for the output list.
     * Since we can’t have more than O(2^N) combinations,
     * the space complexity of our algorithm is O(N*2^N).
     */
    public static List<String> generateValidParentheses(int num) {
        List<String> result = new ArrayList<String>();
        Queue<ParenthesesString> queue = new LinkedList<>();
        queue.add(new ParenthesesString("", 0, 0));
        while (!queue.isEmpty()) {
            ParenthesesString ps = queue.poll();
            // if we've reached the maximum number of open and close parentheses, add to the result
            if (ps.openCount == num && ps.closeCount == num) {
                result.add(ps.str);
            } else {
                if (ps.openCount < num) // if we can add an open parentheses, add it
                    queue.add(new ParenthesesString(ps.str + "(", ps.openCount + 1, ps.closeCount));

                if (ps.openCount > ps.closeCount) // if we can add a close parentheses, add it
                    queue.add(new ParenthesesString(ps.str + ")", ps.openCount, ps.closeCount + 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> result = GenerateParentheses.generateValidParentheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);

        result = GenerateParentheses.generateValidParentheses(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }
}
