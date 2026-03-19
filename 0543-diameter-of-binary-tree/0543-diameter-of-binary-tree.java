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
    public int diameterOfBinaryTree(TreeNode root) {
        return helper(root);
    }
    public int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int ans=(dfs(root.left)+dfs(root.right));
        int ans2=helper(root.left);
        int ans3=helper(root.right);
        return Math.max(ans,Math.max(ans2,ans3));
    }
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+Math.max(dfs(root.left),dfs(root.right));            
    }

}