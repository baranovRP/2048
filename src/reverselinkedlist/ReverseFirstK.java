package reverselinkedlist;

public class ReverseFirstK {
    /**
     * Problem: Reverse the first ‘k’ elements of a given LinkedList.
     * Solution: This problem can be easily converted to our parent problem; to reverse the first ‘k’ nodes of the list,
     * we need to pass p=1 and q=k.
     * <p>
     * Time complexity
     * The time complexity of our algorithm will be O(N) where ‘N’ is the total number of nodes in the LinkedList.
     * <p>
     * Space complexity
     * We only used constant space, therefore, the space complexity of our algorithm is O(1).
     */
    public static ListNode reverse(ListNode head, int k) {
        if (k < 2) return head;
        ListNode current = head, previous = head, lastNode = current;
        ListNode next, firstNode = null;
        for (int i = 0; previous != null && i < k - 1; ++i) {
            firstNode = previous;
            previous = previous.next;
        }
        previous = null;
        for (int i = 0; current != null && i < k; i++) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        firstNode.next = current;
        lastNode.next = current;
        return previous;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseFirstK.reverse(head, 2);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
