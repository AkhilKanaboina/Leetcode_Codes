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
    public ListNode partition(ListNode head, int x) {
        ListNode small=new ListNode(-1,null);
        ListNode smallKey=small;
        ListNode great=new ListNode(-1,null);
        ListNode greatKey=great;
        ListNode curr=head;
        ListNode temp=null;

        while(curr!=null){
            temp=curr.next;
            if(curr.val<x){
                smallKey.next=curr;
                smallKey=smallKey.next;
                smallKey.next=null;
            }else{
                greatKey.next=curr;
                greatKey=greatKey.next;
                greatKey.next=null;
            }
            curr=temp;
        }
        smallKey.next=great.next;
        return small.next;
    }
}