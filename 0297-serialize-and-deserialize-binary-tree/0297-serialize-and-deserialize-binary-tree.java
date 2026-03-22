/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
       Queue<TreeNode> queue=new LinkedList<>();
       StringBuilder str=new StringBuilder();
       queue.offer(root);
       while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node!=null){
                str.append(node.val+",");
                queue.add(node.left);
                queue.add(node.right);
            }else{
                str.append("null,");
            }
       }
       return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty() || data==null) return null;
        Queue<TreeNode> queue=new LinkedList<>();
        String strs[]=data.split(",");
        int n=strs.length;
        if(strs[0].equals("null")) return null;
        int index=1;
        TreeNode root=new TreeNode(Integer.parseInt(strs[0]));
        queue.offer(root);

        while(!queue.isEmpty() && index<n){
            TreeNode node=queue.poll();

            if(!strs[index].equals("null")){
                node.left=new TreeNode(Integer.parseInt(strs[index]));
                queue.offer(node.left);
            }
            index++;
            if(!strs[index].equals("null")){
                node.right=new TreeNode(Integer.parseInt(strs[index]));
                queue.offer(node.right);
            }
            index++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));