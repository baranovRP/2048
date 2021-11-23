package reverselinkedlist;

import java.awt.*;

public class ReverseSubList {


    public static ListNode reverse(ListNode head, int p, int q) {
        int s = p, e = q;
        ListNode end = head;
        while (0 < q) {
            end = end.next;
            q--;
        }
        ListNode subList = createSubList(head, s, e);
        ListNode reversedSubList = reverseSubList(subList);
        ListNode current = head;
        while (1 < p - 1) {
            current = current.next;
            p--;
        }

        current.next = reversedSubList;
        while (1 < e) {
            current = current.next;
            e--;
        }
        current.next = end;
        return head;
    }

    private static ListNode createSubList(ListNode head, int begin, int end) {
        ListNode current = head;
        ListNode endList = current;
        while (1 < begin) {
            current = current.next;
            begin--;
        }
        while (1 < end) {
            endList = endList.next;
            end--;
        }
        endList.next = null;
        return current;
    }

    private static ListNode reverseSubList(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    /**
     * Time complexity
     * The time complexity of our algorithm will be O(N) where ‘N’ is the total number of nodes in the LinkedList.
     * <p>
     * Space complexity
     * We only used constant space, therefore, the space complexity of our algorithm is O(1).
     */
    public static ListNode reverse2(ListNode head, int p, int q) {
        if (p == q)
            return head;

        // after skipping 'p-1' nodes, current will point to 'p'th node
        ListNode current = head, previous = null;
        for (int i = 0; current != null && i < p - 1; ++i) {
            previous = current;
            current = current.next;
        }

        // we are interested in three parts of the LinkedList, part before index 'p', part between 'p' and
        // 'q', and the part after index 'q'
        ListNode lastNodeOfFirstPart = previous; // points to the node at index 'p-1'
        // after reversing the LinkedList 'current' will become the last node of the sub-list
        ListNode lastNodeOfSubList = current;
        ListNode next = null; // will be used to temporarily store the next node
        // reverse nodes between 'p' and 'q'
        for (int i = 0; current != null && i < q - p + 1; i++) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        // connect with the first part
        if (lastNodeOfFirstPart != null)
            lastNodeOfFirstPart.next = previous; // 'previous' is now the first node of the sub-list
        else // this means p == 1 i.e., we are changing the first node (head) of the LinkedList
            head = previous;

        // connect with the last part
        lastNodeOfSubList.next = current;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseSubList.reverse2(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
