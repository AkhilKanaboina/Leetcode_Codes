/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean ans=false;
    public boolean isBalanced(TreeNode root) {
       dfs(root);
       return !ans;
    }
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        if(ans){
            return 0;
        }
        int left=1+dfs(root.left);
        int right=1+dfs(root.right);
        int temp=Math.abs(left-right);
        if(temp>1){
            ans=true;
            return 0;
        }
        return Math.max(left,right);
    }
   
}