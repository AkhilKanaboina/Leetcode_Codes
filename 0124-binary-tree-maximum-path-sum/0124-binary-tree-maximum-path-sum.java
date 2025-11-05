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
    int ans=0;
    public int maxPathSum(TreeNode root) {
        ans=root.val;
        preOrder(root);
        return ans;
    }
    public void preOrder(TreeNode root){
        if(root==null){
            return ;
        }
        int val=root.val;
        val+=dfs(root.left);
        val+=dfs(root.right);
        ans=Math.max(val,ans);
        preOrder(root.left);
        preOrder(root.right);
    }
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int val=root.val;
        val+=Math.max(dfs(root.left),Math.max(dfs(root.right),0));
     //   ans=Math.max(val,ans);
        return Math.max(val,0);
    }
}