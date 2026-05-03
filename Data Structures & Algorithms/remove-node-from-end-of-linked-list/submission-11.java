/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // edge cases
        if (head == null || head.next == null) return null;

        // Set two pointers 'first' and 'second',
        // those two will traverse the linked list
        // being n nodes apart
        ListNode first = head;
        ListNode second = head;
        
        // Move 'first' forward by n nodes,
        // this will guarantee us that the node
        // at 'second' is the one just before the node
        // that we have to remove.
        // The constraints don't tell us that 'n' could be
        // greater than the linked list length so we will
        // ignore that for now.
        while (n > 0) {
            // If the reached the end of the chain but
            // n != 0, then we have to remove the first node.
            if (first.next == null) {
                return second.next;
            }
            first = first.next;
            n--;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        // Set 'second.next' to be 'second.next.next'
        // and return head, this works even if the
        // last node is the one that should be removed.
        second.next = second.next.next;
        return head;
    }
}
