package level2;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        // Floyd's Tortoise and Hare algorithm
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // For testing: create a list with a cycle at position 'pos'
    public static ListNode createList(int[] vals, int pos) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode cycleNode = null;
        for (int i = 0; i < vals.length; i++) {
            curr.next = new ListNode(vals[i]);
            curr = curr.next;
            if (i == pos) cycleNode = curr;
        }
        if (cycleNode != null) curr.next = cycleNode;
        return dummy.next;
    }

    public static void main(String[] args) {
        // Example 1: head = [3,2,0,-4], pos = 1
        int[] vals1 = {3,2,0,-4};
        ListNode head1 = createList(vals1, 1);
        System.out.println(new LinkedListCycle().hasCycle(head1)); // true

        // Example 2: head = [1,2], pos = 0
        int[] vals2 = {1,2};
        ListNode head2 = createList(vals2, 0);
        System.out.println(new LinkedListCycle().hasCycle(head2)); // true

        // Example 3: head = [1], pos = -1 (no cycle)
        int[] vals3 = {1};
        ListNode head3 = createList(vals3, -1);
        System.out.println(new LinkedListCycle().hasCycle(head3)); // false
    }
}
