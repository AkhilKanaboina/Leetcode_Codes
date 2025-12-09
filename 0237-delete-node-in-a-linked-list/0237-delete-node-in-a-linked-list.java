/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // ListNode prev=null;
         ListNode curr=node;
         ListNode next=curr.next;
         ListNode prev=null;
        while(curr!=null && next!=null){
            curr.val=next.val;
            prev=curr;
            curr=next;
            next=curr.next;
        }
        prev.next=null;
    }
}