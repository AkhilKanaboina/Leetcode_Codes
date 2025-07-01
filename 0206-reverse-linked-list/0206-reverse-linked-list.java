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
    public ListNode reverseList(ListNode head) {
        ListNode current,prev;
        current=head;
      //  Next=current.next;
      prev=null;

        while(current!=null){
          ListNode  Next=current.next;
            current.next=prev;
            prev=current;
            current=Next;  
        }
        head=prev;
        return head;
    }
}