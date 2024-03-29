package fastslowpointers;

class LinkedListCycleStart {

    public static ListNode findCycleStart(ListNode head) {
        ListNode slow = head, fast = head;
        int cycleL = -1;
        while (fast != null || fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                cycleL = findCycleLength(slow);
                break;
            }
        }
        ListNode pointer1 = head, pointer2 = head;
        for (int i = 0; i < cycleL; i++) {
            pointer2 = pointer2.next;
        }
        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        return pointer1;
    }


    private static int findCycleLength(ListNode node) {
        ListNode slow = node;
        int counter = 0;
        do {
            counter++;
            slow = slow.next;
        } while (slow != node);
        return counter;
    }

    /**
     * Time Complexity
     * As we know, finding the cycle in a LinkedList with ‘N’ nodes
     * and also finding the length of the cycle requires O(N).
     * Also, as we saw in the algorithm, we will need O(N) to find the start of the cycle.
     * Therefore, the overall time complexity of our algorithm will be O(N).

     * Space Complexity
     * The algorithm runs in constant space O(1).
     */
    public static ListNode findCycleStart2(ListNode head) {
        int cycleLength = 0;
        // find the LinkedList cycle
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) { // found the cycle
                cycleLength = calculateCycleLength(slow);
                break;
            }
        }

        return findStart(head, cycleLength);
    }

    private static int calculateCycleLength(ListNode slow) {
        ListNode current = slow;
        int cycleLength = 0;
        do {
            current = current.next;
            cycleLength++;
        } while (current != slow);

        return cycleLength;
    }

    private static ListNode findStart(ListNode head, int cycleLength) {
        ListNode pointer1 = head, pointer2 = head;
        // move pointer2 ahead 'cycleLength' nodes
        while (cycleLength > 0) {
            pointer2 = pointer2.next;
            cycleLength--;
        }

        // increment both pointers until they meet at the start of the cycle
        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return pointer1;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
    }
}