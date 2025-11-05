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
    List<Integer> list=new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        dfs(root,0);
        int ans=Integer.MIN_VALUE;
        for(int temp:list){
            if(ans==Integer.MIN_VALUE){
                ans=temp;
                continue;
            }
            ans+=temp;
        }
        return ans;
    }
    public void dfs(TreeNode root,int val){
        val=val*10;
        if(root.left==null && root.right==null){
            list.add(val+root.val);
        }else if(root.left==null){
            dfs(root.right,root.val+val);
        }else if(root.right==null){
             dfs(root.left,root.val+val);
        }else{
            dfs(root.left,root.val+val);
            dfs(root.right,root.val+val);
        }    
    }
}