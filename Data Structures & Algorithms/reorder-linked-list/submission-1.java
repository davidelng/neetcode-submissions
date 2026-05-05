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
    public void reorderList(ListNode head) {
        // To reorder the list we have to split it into two halves.
        // First, let's find the midpoint using fast and slow pointers.
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Then we reverse the list from the midpoint to the end.
        ListNode second = slow.next; // Save start of second half
        ListNode prev = null; // Initialize null prev pointer
        slow.next = null; // Disconnect first and second halves
        while (second != null) {
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }

        // Having the first half unchanged and the second half reversed,
        // we can join them using one node from each to get the result.
        ListNode first = head; // Start of first half
        // Reset second pointer to the start of the second half after reversing,
        // this is the last node in the second list that now moves inward
        // since it is reversed.
        second = prev;
        while (second != null) {
            // On each iteration take a node from second and insert it
            // after first.
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }
}
