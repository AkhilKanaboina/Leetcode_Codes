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
    public ListNode oddEvenList(ListNode head) {
        ListNode dummy=new ListNode(-1);
        ListNode dummy2=new ListNode(-1);
        int counter=0;
        ListNode temp=head;
        ListNode temp1=dummy;
        ListNode temp2=dummy2;
        while(temp!=null){
            if(counter%2==0){
                temp1.next=temp;
                temp=temp.next;
                temp1=temp1.next;
            }else{
                temp2.next=temp;
                temp=temp.next;
                temp2=temp2.next;
            }
            counter++;
        }
        temp2.next=null;
        temp1.next=dummy2.next;
        return dummy.next;

    }
}