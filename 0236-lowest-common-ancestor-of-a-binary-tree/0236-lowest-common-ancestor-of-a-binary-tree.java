/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<TreeNode> list=new ArrayList<>();
    List<List<TreeNode>> ans=new ArrayList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p.val);
        list.clear();
        dfs(root,q.val);
        TreeNode ansNode=root;
        int p_size=ans.get(0).size();
        int q_size=ans.get(1).size();
        int i=0;
        while(i<p_size && i<q_size){
            if(ans.get(0).get(i).val==ans.get(1).get(i).val){
                ansNode=ans.get(0).get(i);
                i++;
            }else{
                break;
            }
        }
        return ansNode;
    }

    public boolean dfs(TreeNode root,int target){
        if(root==null){
            return false;
        }
        list.add(root);
        if(root.val==target){
            ans.add(new ArrayList<>(list));
            return true;
        }
        if(dfs(root.left,target)||dfs(root.right,target)){
            return true;
        }
        list.remove(list.size()-1);
        return false;
    }
}