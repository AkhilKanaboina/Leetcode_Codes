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
         ListNode head=null;
         ListNode temp=null;
    public void create(int n){
        if(head==null){
            head=new ListNode(n);
            head.next=null;
            temp=head;
        }else{
        temp.next=new ListNode(n);
        temp=temp.next;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list=new ArrayList<>();
        for(ListNode head:lists){
            while(head!=null){
                list.add(head.val);
                head=head.next;
            }
        }
        Collections.sort(list);
        for(int i:list){
            create(i);
        }

        return head;
    }
}