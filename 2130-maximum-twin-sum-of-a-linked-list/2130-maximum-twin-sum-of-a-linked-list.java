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
    public int pairSum(ListNode head) {
        Stack<Integer> stack=new Stack<>();
        ListNode temp=head;
        while(temp!=null){
            stack.push(temp.val);
            temp=temp.next;
        }
        ListNode fast=head;
        ListNode slow=head;
        int ans=0;
        while(fast!=null && fast.next!=null){
            ans=Math.max(ans,slow.val+stack.pop());
            slow=slow.next;
            fast=fast.next.next;
        }
       
        return ans;
    }
}