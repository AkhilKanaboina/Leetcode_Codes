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
    List<String> list=new ArrayList<>();
    public String smallestFromLeaf(TreeNode root) {
        dfs(root,"");
        Collections.sort(list);
        return list.get(0);
    }
    public void dfs(TreeNode root,String str){
        if(root==null){
            return;
        }
        String newPath = (char)(root.val+'a') + str;
        if(root.left==null && root.right==null){
            list.add(newPath);
            return ;
        }
        dfs(root.left,newPath);
        dfs(root.right,newPath);
    }
}