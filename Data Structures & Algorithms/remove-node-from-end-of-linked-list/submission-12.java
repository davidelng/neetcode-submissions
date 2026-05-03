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
        // We can use two pointers and the dummy node
        // approach to solve this problem with fewer lines
        // of code.
        // We will use the two pointers 'left' and 'right'
        // to iterate the list while keeping them 'n' nodes
        // apart, this will guarantee us that 'left' will be
        // just before the node to remove.
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = head;

        // The constraints don't mention 'n' being
        // greater than the linked list length so
        // we can iterate 'right' safely.
        while (n > 0) {
            right = right.next;
            n--;
        }

        // We can iterate until 'right' is null because
        // left started as a dummy node and moved forward
        // being in fact n+1 nodes behind right.
        // When 'right' reaches null, then 'left' is behind
        // the nth node to be removed.
        while (right != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;
        return dummy.next;
    }
}
