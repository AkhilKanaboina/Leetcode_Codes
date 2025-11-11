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
    StringBuilder ans=new StringBuilder();
    public String getDirections(TreeNode root, int startValue, int destValue) {
       ans.setLength(0);
       TreeNode Lowest_Ancestor=LCA(root,startValue,destValue);
       dfs(Lowest_Ancestor,startValue,new StringBuilder(),true);
       dfs(Lowest_Ancestor,destValue,new StringBuilder(),false);
       return ans.toString();
    }
    public TreeNode LCA(TreeNode root, int p,int q){
        if(root==null){
            return null;
        }
        if(root.val==p ||root.val==q){
            return root;
        }
        TreeNode left=LCA(root.left,p,q);
        TreeNode right=LCA(root.right,p,q);
        if(left!=null && right!=null){
            return root;
        }else if(left!=null){
            return left;
        }else{
            return right;
        }
    }
    public boolean dfs(TreeNode root,int node,StringBuilder str,boolean b){
        if(root==null){
            return false;
        }
        if(root.val==node){
            if(b){
                ans.append("U".repeat(str.length()));
            }else{
                 ans.append(str);
            }
            return true;
        }
        str.append('L');
        if(dfs(root.left,node,str,b)){
            return true;
        }
        str.deleteCharAt(str.length()-1);
        str.append('R');

        if(dfs(root.right,node,str,b)){
            return true;
        }
        str.deleteCharAt(str.length()-1);

        return false;
    }
}