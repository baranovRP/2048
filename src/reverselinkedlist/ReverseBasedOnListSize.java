package reverselinkedlist;

public class ReverseBasedOnListSize {

    public static ListNode reverse(ListNode head) {
        ListNode current = head;
        int counter = 0;
        while (current != null) {
            current = current.next;
            counter++;
        }
        head = reverseSublist(head, 1, counter / 2);
        if (counter % 2 == 0) {
            head = reverseSublist(head, counter / 2 + 1, counter);
        } else {
            head = reverseSublist(head, counter / 2 + 2, counter);
        }
        return head;
    }

    private static ListNode reverseSublist(ListNode head, int p, int q) {
        if (p == q) return head;
        ListNode current = head, previous = null;
        for (int i = 0; current != null && i < p - 1; i++) {
            previous = current;
            current = current.next;
        }
        ListNode lastNodeOfFirstPart = previous, lastNodeOfSublist = current, next = null;
        for (int i = 0; current != null && i < q - p + 1; i++) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        if (lastNodeOfFirstPart != null) {
            lastNodeOfFirstPart.next = previous;
        } else {
            head = previous;
        }
        lastNodeOfSublist.next = current;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseBasedOnListSize.reverse(head);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        result = ReverseBasedOnListSize.reverse(head);
        System.out.print("\nNodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }

}
