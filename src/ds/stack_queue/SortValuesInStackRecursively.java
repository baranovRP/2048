package ds.stack_queue;

public class SortValuesInStackRecursively {

    public static void insert(Stack<Integer> stack, int value) {
        if (stack.isEmpty() || value < stack.top()) stack.push(value);
        else {
            int temp = stack.pop();
            insert(stack, value);
            stack.push(temp);
        }
    }

    /**
     * Time Complexity
     * The sortStack function is recursively called on all n elements.
     * In the worst case, there are n calls to insert for each element.
     * This pushes the time complexity up to O(n2).
     * However, unlike the first solution, we do not need to create another stack.
     */
    public static Stack<Integer> sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int value = stack.pop();
            sortStack(stack);
            insert(stack, value);
        }
        return stack;
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<Integer>(7);
        stack.push(2);
        stack.push(97);
        stack.push(4);
        stack.push(42);
        stack.push(12);
        stack.push(60);
        stack.push(23);
        sortStack(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
