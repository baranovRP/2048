package lc;

public class ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Time  = O(N)
    // Space = O(1)
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode temp = null;
        ListNode current = head;
        while (current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return prev;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode prev=null;
        ListNode next=null;
        ListNode current=head;
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }

        return prev;
    }

    // Time  = O(N)
    // Space = O(N)
    public ListNode reverseListRecursively(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseListRecursively(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
