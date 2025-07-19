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
    public boolean isValidBST(TreeNode root) {
    List<Integer> inOrderVal = new ArrayList<>();
    inorder(root, inOrderVal);
    for (int i = 1; i < inOrderVal.size(); i++) {
        if (inOrderVal.get(i - 1) >= inOrderVal.get(i)) {
            return false;
        }
    }
    return true;
}

private void inorder(TreeNode root, List<Integer> inOrderVal) {
    if (root == null) return;
    inorder(root.left, inOrderVal);
    inOrderVal.add(root.val);
    inorder(root.right, inOrderVal);
}

}