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
    List<Integer> inOrderVal=new ArrayList<Integer>();
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        inOrderVal.add(root.val);
        inorder(root.right);
    }
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        for(int i=1;i<inOrderVal.size();i++){
            if(inOrderVal.get(i-1)>inOrderVal.get(i)){
                return false;
            }
        }
        return true;
    }
}