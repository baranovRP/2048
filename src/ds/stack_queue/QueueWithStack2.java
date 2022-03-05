package ds.stack_queue;

class QueueWithStack2<V> {
    //We can use 2 stacks for this purpose, stack1 to store original values
    //and stack2 which will help in dequeue operation.
    Stack<V> stack1;
    Stack<V> stack2;

    /**
     * Time Complexity
     * This solution is more optimized than the previous one,
     * as the transfer of elements between stacks takes place only if stack2 is empty.
     * Most of the time, we will be doing stack2.pop() from the else clause, which is O(1).
     * Occasionally, we will find stack2 empty and pop elements over from stack1 onto stack2.
     * But once we’ve done that, stack2 is no longer empty,
     * and we’d be going to the else clause again with the O(1) time complexity.
     * Therefore, the amortized complexity of the dequeue operation becomes O(1).
     * While the time complexity for the enqueue operation is O(1) as well.
     * <p>
     * Note: We use amortized complexity analysis with data structures
     * that have a state which persists between operations.
     * So, a costly operation will change the state such that it will take a long time
     * for the worst-case to happen again, which amortizes its cost
     */
    public QueueWithStack2(int maxSize) {
        stack1 = new Stack<>(maxSize);
        stack2 = new Stack<>(maxSize);
    }

    public boolean isEmpty() {
        return (stack1.isEmpty() && stack2.isEmpty());
    }

    public void enqueue(V value) {
        stack1.push(value);
    }

    public V dequeue() {
        //return null if both the stacks are empty 
        if (isEmpty()) {
            return null;
        } else if (stack2.isEmpty()) {
            //if stack2 is empty, we pop all the elements
            //from stack1 and push them to the stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            //finally, we return the top of stack2
            return stack2.pop();
        } else {
            //if none of the above conditions are true
            //we will simply return the top of stack2
            return stack2.pop();
        }
    }

}