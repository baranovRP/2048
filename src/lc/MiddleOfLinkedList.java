package lc;

public class MiddleOfLinkedList {

    public ReverseLinkedList.ListNode middleNode(ReverseLinkedList.ListNode head) {
        if (head == null || head.next == null) return head;
        ReverseLinkedList.ListNode slow = head.next;
        ReverseLinkedList.ListNode fast = head.next.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }

    // Time = O(N)
    // Space = O(1)
    public ReverseLinkedList.ListNode middleNode1(ReverseLinkedList.ListNode head) {
        ReverseLinkedList.ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
