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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set=new HashSet<>();
        for(int val:nums){
            if(!set.contains(val)){
                set.add(val);
            }
        }
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode prev=dummy;
        ListNode curr=head;
        while(curr!=null){
            if(set.contains(curr.val)){
                prev.next=curr.next;
                // prev=prev.next;
                curr=curr.next;
                continue;
            }
            prev=curr;
            curr=curr.next;
        }
        return dummy.next;
    }
}