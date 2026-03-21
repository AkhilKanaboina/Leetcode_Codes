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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int last=preorder.length;
        int first=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int i=0;
        for(int val:inorder){
            map.put(val,i++);
        }
        TreeNode root=createTree(preorder,inorder,first,last,0,map);
        return root;
    }
    public TreeNode createTree(int preorder[],int inorder[],int first,int last,int index,HashMap<Integer,Integer> map){
        if(index>=preorder.length) return null;
        if(last<first) return null;
        TreeNode root= new TreeNode(preorder[index]);
        int pos=map.get(preorder[index]);
        
        root.left=createTree(preorder,inorder,first,pos-1,index+1,map);
        root.right=createTree(preorder,inorder,pos+1,last,index+2,map);
        return root;
    }
    
}