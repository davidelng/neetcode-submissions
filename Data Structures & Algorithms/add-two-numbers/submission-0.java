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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Use a dummy to return the start of the result linked list.
        ListNode dummy = new ListNode();
        // Node that we will actually use to build the list.
        ListNode curr = dummy;
        // We need to keep track of the carry because the list values are
        // single digits but can sum up to two-digits.
        int carry = 0;
        // If one of the two list ends, we keep going and add 0.
        while (l1 != null || l2 != null || carry != 0) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = v1 + v2 + carry;
            // If sum is two-digits take the carry to the next node
            carry = sum / 10;
            // The remainder (or single digit) goes in the current node
            int digit = sum % 10;
            curr.next = new ListNode(digit);
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummy.next;
    }
}
