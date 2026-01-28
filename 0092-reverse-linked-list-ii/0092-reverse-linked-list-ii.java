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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode prevStart = null;
        ListNode curr = head;

        // Move `curr` to the start position
        for (int i = 1; i < left; i++) {
            prevStart = curr;
            curr = curr.next;
        }

        // Start reversal
        ListNode prev = null;
        ListNode tail = curr;
        for (int i = left; i <= right; i++) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        // Connect reversed part back
        if (prevStart != null) {
            prevStart.next = prev;
        } else {
            head = prev;  // If reversing from head
        }

        tail.next = curr;  // Connect tail to the remaining list

        return head;
    }
}
