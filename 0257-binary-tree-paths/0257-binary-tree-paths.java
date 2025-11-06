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
    List<String> str=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root,"");
        return str;
    }
    public void dfs(TreeNode root,String s){
        if(root==null){
            return ;
        }
        if(root.left==null && root.right==null){
            str.add(s+root.val);
        }
        dfs(root.left,s+root.val+"->");
        dfs(root.right,s+root.val+"->");
    }
}