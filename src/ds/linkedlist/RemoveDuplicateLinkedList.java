package ds.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateLinkedList {

    /**
     * Time Complexity
     * The time complexity is O(nlogn).
     */
    public static <T> void removeDuplicates(SinglyLinkedList<T> list) {
        Set<T> origins = new HashSet<>();
        SinglyLinkedList<T>.Node head = list.headNode;
        SinglyLinkedList<T>.Node prev = list.headNode;
        SinglyLinkedList<T>.Node next;
        while (head != null) {
            next = head.nextNode;
            if (origins.contains(head.data)) {
                head = next;
                prev.nextNode = next;
            } else {
                origins.add(head.data);
                prev = head;
                head = next;
            }
        }
    }

    /**
     * Time Complexity
     * This algorithm has two nested loops.
     * Hence, the time complexity is O(n^2).
     */
    public static <T> void removeDuplicates2(SinglyLinkedList<T> list) {
        SinglyLinkedList<T>.Node current = list.headNode; // will be used for outer loop
        SinglyLinkedList<T>.Node compare = null;     // will be used for inner loop

        while (current != null && current.nextNode != null) {
            compare = current;
            while (compare.nextNode != null) {
                if (current.data.equals(compare.nextNode.data)) { //check if duplicate
                    compare.nextNode = compare.nextNode.nextNode;
                } else {
                    compare = compare.nextNode;
                }
            }
            current = current.nextNode;
        }
    }

    public static void main(String args[]) {

        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        for (int i = 0; i < 9; i++)
            list.insertAtEnd(i);
        list.insertAtEnd(0);
        list.insertAtEnd(1);
        System.out.print("Before ");
        list.printList();
        removeDuplicates(list);
        System.out.print("After ");
        list.printList();

    }

}
