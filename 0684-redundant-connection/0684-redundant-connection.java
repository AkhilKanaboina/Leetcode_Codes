class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        boolean visited[]=new boolean[n+1];
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int edge[]:edges){
            Arrays.fill(visited,false);
            if(dfs(edge[0],edge[1],graph,visited)) return edge;
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return new int[]{};
        
    }
    public boolean dfs(int src,int dest,ArrayList<ArrayList<Integer>> graph,boolean visited[]){

        if(src==dest) return true;
        visited[src]=true;
        for(int neigh:graph.get(src)){
            if(!visited[neigh] && dfs(neigh,dest,graph,visited)) return true;
        }
        return false;
    }
}