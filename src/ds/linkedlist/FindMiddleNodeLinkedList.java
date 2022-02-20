package ds.linkedlist;

public class FindMiddleNodeLinkedList {

    /**
     * Time Complexity
     * <p>
     * We are traversing the linked list at twice the speed, so it is certainly faster.
     * However, the bottleneck complexity is still O(n).
     */
    public static <T> Object findMiddle(SinglyLinkedList<T> list) {
        //if list is empty, then return null
        if (list.isEmpty())
            return null;

        //both nodes start from the head
        SinglyLinkedList<T>.Node mid = list.headNode;
        SinglyLinkedList<T>.Node current = list.headNode;

        while (mid != null && current != null && current.nextNode != null) {
            //current jumps 2 nodes on each iteration
            current = current.nextNode.nextNode;
            //if current is not null (end of list is not reached)
            if (current != null) {
                //then mid jumps 1 node
                //mid is always halfway behind current
                mid = mid.nextNode;
            }
        }
        return mid.data;
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.insertAtEnd(1);
        list.insertAtEnd(2);

        list.insertAtEnd(123);
        list.insertAtEnd(101);
        list.insertAtEnd(61);
//        list.insertAtEnd(63);
        list.printList();
        System.out.println("Middle element is : " + findMiddle(list));
    }
}
