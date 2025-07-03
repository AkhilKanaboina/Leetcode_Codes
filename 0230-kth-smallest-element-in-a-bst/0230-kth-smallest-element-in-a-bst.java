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
    ArrayList<Integer> list=new ArrayList<>();
    public void inorder(TreeNode root){
        if(root==null){
            return ;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        int min=Integer.MIN_VALUE;
        int counter=0;
        for(int i:list){
            if(min<i){
                min=i;
                counter++;
                if(counter==k)
                return min;
            }
        }
        return min;
    }
}