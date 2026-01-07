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
    long max=0;
    public int maxProduct(TreeNode root) {
        long sum=totalSum(root);
        dfs(root,sum);
        return (int)(max%1_000_000_007);
    }
    private long totalSum(TreeNode root){
        if(root==null){
            return 0;
        }
        return root.val+ totalSum(root.left)+ totalSum(root.right);
    }
    private long dfs(TreeNode root,long sum){
        if(root==null){
            return 0;
        }
        long left=dfs(root.left,sum);
        long right=dfs(root.right,sum);

        long total=left+right+root.val;
        max=Math.max(max,(sum-total)*total);

        return total;
    }

}