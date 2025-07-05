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
      if(head==null||left==right) return head;
      ListNode A=null,B=null;
      ListNode prev=null,curr=null;
      curr=head;
      for(int i=1;i<left;i++){
        A=curr;
        curr=curr.next;
      }
      B=curr;
      for(int i=left;i<=right;i++){
        ListNode cN=curr.next;
        curr.next=prev;
        prev=curr;
        curr=cN;
      }
      if(A!=null){
        A.next=prev;
      }else{
        head=prev;
      }
      B.next=curr;
      return head;

    }
}