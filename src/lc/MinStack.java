package lc;

import java.util.Stack;

public class MinStack {

    Stack<Integer> mainStack;
    Stack<Integer> minStack;
    //constructor
    public MinStack() {
        //We will use two stacks mainStack to hold original values
        //and minStack to hold minimum values. Top of minStack will always
        //be the minimum value from mainStack
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }
    //removes and returns value from stack
    public int pop(){
        //1. Pop element from minStack to make it sync with mainStack,
        //2. Pop element from mainStack and return that value
        minStack.pop();
        return mainStack.pop();
    }
    //pushes value into the stack
    public void push(Integer value){
        //1. Push value in mainStack and check value with the top value of minStack
        //2. If value is greater than top, then push top in minStack
        //else push value in minStack
        mainStack.push(value);
        if(!minStack.isEmpty() && minStack.peek() < value)
            minStack.push(minStack.peek());
        else
            minStack.push(value);
    }

    public int top() {
        return mainStack.peek();
    }

    //returns minimum value in O(1)
    public int getMin(){
        return minStack.peek();
    }
}

class MyNode {
    int val;
    int min;
    MyNode next;
}

class MyMinStack {
    MyNode head = null;
    int size;

    public MyMinStack() {
        head = new MyNode();
        size = 0;
    }

    public void push(int val) {
        MyNode node = new MyNode();
        if (size == 0) {
            node.min = val;
        } else {
            node.min = Math.min(head.min, val);
        }
        node.val = val;
        node.next = head;
        head = node;
        size++;
    }

    public void pop() {
        if (size == 0) return;
        head = head.next;
        size--;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}