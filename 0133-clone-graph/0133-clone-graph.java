/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return node;

        return createClone(node);
    }
    public Node createClone(Node node){
        Queue<Node> queue=new LinkedList<>();
        queue.offer(node);
        HashMap<Node,Node> map=new HashMap<>();
        map.put(node,new Node(node.val));
        while(!queue.isEmpty()){
            Node current=queue.poll();

            for(Node neighbor:current.neighbors){
                
                if(!map.containsKey(neighbor)){
                    map.put(neighbor,new Node(neighbor.val));
                    queue.offer(neighbor);//not visited so clone node not created
                }
                map.get(current).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}