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
   private List<List<Integer>> list=new ArrayList<>();
   private List<Integer> currentPath=new ArrayList<>();
    public void dfs(TreeNode root,int sum){
        if(root==null){
        return ;
        }
            sum-=root.val;
            currentPath.add(root.val);
            if(sum==0&&root.left==null&&root.right==null){
                list.add(new ArrayList<>(currentPath));
            }
            dfs(root.left,sum);
            dfs(root.right,sum);
        
           currentPath.remove(currentPath.size()-1);    
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum);
        return list;
    }
}