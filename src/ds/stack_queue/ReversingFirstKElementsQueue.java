package ds.stack_queue;

public class ReversingFirstKElementsQueue {

    //1.Push first k elements in queue in a stack.
    //2.Pop Stack elements and enqueue them at the end of queue
    //3.Dequeue queue elements till "k" and append them at the end of queue
    //4.Dequeue the remaining elements and enqueue them again to append them at end of the queue

    /**
     * Time Complexity
     * Overall, kkk elements are dequeued, pushed to the stack, popped from it, and then enqueued.
     * Additionally, n−kn-kn−k elements are dequeued and enqueued to the queue.
     * Each push, pop, enqueue, or dequeue operation takes constant time;
     * the time complexity of this method is O(n) as all n elements have to be processed with constant-time operations.
     */
    public static <V> void reverseK(Queue<V> queue, int k) {
        if (queue.isEmpty() || k <= 0)
            return;
        Stack<V> stack = new Stack<>(k);

        while (!stack.isFull())
            stack.push(queue.dequeue());

        while (!stack.isEmpty())
            queue.enqueue(stack.pop());

        int size = queue.getCurrentSize();
        for (int i = 0; i < size - k; i++)
            queue.enqueue(queue.dequeue());
    }

    public static void main(String args[]) {

        Queue<Integer> queue = new Queue<Integer>(10);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);

        reverseK(queue, 5);

        System.out.print("Queue: ");
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
    }
}
