public class OddEvenLinklistSolution {
    static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int val) {
             this.val = val; 
            } 
    }

    
    public ListNode oddEvenList(ListNode head) {
        if (head == null) 
        return null;
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        
        odd.next = evenHead;
        return head;
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        OddEvenLinklistSolution sol = new OddEvenLinklistSolution();
        
        // Test case 1: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        ListNode result1 = sol.oddEvenList(head1);
        printList(result1); // Expected: 1 3 5 2 4


        
        // Test case 2: 2 -> 1 -> 3 -> 5 -> 6 -> 4 -> 7
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(5);
        head2.next.next.next.next = new ListNode(6);
        head2.next.next.next.next.next = new ListNode(4);
        head2.next.next.next.next.next.next = new ListNode(7);
        ListNode result2 = sol.oddEvenList(head2);
        printList(result2); // Expected: 2 3 6 7 1 5 4

        // Test case 3: Single node
        ListNode head3 = new ListNode(10);
        ListNode result3 = sol.oddEvenList(head3);
        printList(result3); // Expected: 10

        // Test case 4: Two nodes
        ListNode head4 = new ListNode(1);
        head4.next = new ListNode(2);
        ListNode result4 = sol.oddEvenList(head4);
        printList(result4); // Expected: 1 2
    }

}
