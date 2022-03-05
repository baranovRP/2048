package ds.stack_queue;

class QueueWithStack1<V> {
    //We can use 2 stacks for this purpose, stack1 to store original values
    //and stack2 which will help in dequeue operation.
    Stack<V> stack1;
    Stack<V> stack2;

    public QueueWithStack1(int maxSize){
        stack1 = new Stack<>(maxSize);
        stack2 = new Stack<>(maxSize);
    }
    public boolean isEmpty(){
        return stack1.isEmpty();
    }
    public void enqueue(V value){
        stack1.push(value);
    }
    public V dequeue(){
        //Traverse stack1 and pop all elements in stack2
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        //pop from stack2 (which was at the end of stack1)
        V result = stack2.pop();
        //put all elements back in stack1
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return result;
    }

}
