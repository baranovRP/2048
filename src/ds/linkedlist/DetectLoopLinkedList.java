package ds.linkedlist;

public class DetectLoopLinkedList {

    /**
     * Floyd’s Cycle Detection Algorithm
     * <p>
     * Time Complexity
     * The algorithm runs in Constant with O(n) with the Auxiliary Space complexity of O(1).
     */
    public static <T> boolean detectLoop(SinglyLinkedList<T> list) {
        SinglyLinkedList<T>.Node slow = list.headNode;
        SinglyLinkedList<T>.Node fast = list.headNode;

        while (slow != null && fast != null && fast.nextNode != null) {
            slow = slow.nextNode;    //the slow pointer will jump 1 step
            fast = fast.nextNode.nextNode; //the fast pointer will jump 2 steps
            // when the pointers become equal then there must be a loop
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.insertAtHead(1);
        list.insertAtHead(2);
        list.insertAtHead(3);
        System.out.println("Before adding loop: " + detectLoop(list));
        list.headNode.nextNode.nextNode = list.headNode;
        System.out.println("After adding loop: " + detectLoop(list));
    }
}
