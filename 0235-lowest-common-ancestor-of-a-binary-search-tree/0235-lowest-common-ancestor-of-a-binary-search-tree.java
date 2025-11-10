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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LCA(root,p);
        List<TreeNode> dest=new ArrayList<>(list);
        list.clear();
        LCA(root,q);
        TreeNode ans=null;
        int key=0;
        while(key<list.size() &&key< dest.size()){
            if(list.get(key)==dest.get(key)){
                ans=list.get(key);
            }else{
                break;
            }
            key++;
        }
        return ans;
        
    }
    public boolean LCA(TreeNode root,TreeNode temp){
        if(root==null){
            return false;
        }
        list.add(root);
        if(root.val==temp.val){
            return true;
        }
        if(root.val>temp.val){
            if(LCA(root.left,temp)) return true;
        }else{
            if(LCA(root.right,temp)) return true;
        }
        list.remove(list.size()-1);
        return false;
    }
}