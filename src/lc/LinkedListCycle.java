package lc;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class LinkedListCycle {

    public boolean hasCycle(ReverseLinkedList.ListNode head) {
        if (head == null || head.next == null) return false;
        ReverseLinkedList.ListNode slow = head;
        ReverseLinkedList.ListNode fast = head.next;
        while (slow != null && fast != null && fast.next != null) {
            if (slow.equals(fast)) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    // Time  = O(N)
    // Space = O(N)
    public boolean hasCycle2(ReverseLinkedList.ListNode head) {
        Set<ReverseLinkedList.ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            }
            nodesSeen.add(head);
            head = head.next;
        }
        return false;
    }

    // Time  = O(N)
    // Space = O(1)
    public boolean hasCycle3(ReverseLinkedList.ListNode head) {
        if (head == null) {
            return false;
        }

        ReverseLinkedList.ListNode slow = head;
        ReverseLinkedList.ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
