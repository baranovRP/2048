package lc;

public class CircularQueue {
    int [] arr;
    int head = 0;
    int tail = 0;
    int size = 0;

    public CircularQueue(int k) {
        arr = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        arr[tail++ % arr.length]=value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        head++;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return arr[head % arr.length];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return arr[(tail-1) % arr.length];
    }

    public boolean isEmpty() {
        return head >= tail;
    }

    public boolean isFull() {
        return size == arr.length;
    }
    public static void main(String[] args) {
        CircularQueue myCircularQueue = new CircularQueue(3);
        myCircularQueue.enQueue(1); // return True
        myCircularQueue.enQueue(2); // return True
        myCircularQueue.enQueue(3); // return True
        myCircularQueue.enQueue(4); // return False
        myCircularQueue.Rear();     // return 3
        myCircularQueue.isFull();   // return True
        myCircularQueue.deQueue();  // return True
        myCircularQueue.enQueue(4); // return True
        myCircularQueue.Rear();     // return 4
    }
}
