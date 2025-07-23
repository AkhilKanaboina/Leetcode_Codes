class Solution {
    public void bfs(boolean visited[],int node,List<List<Integer>> graph){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(node);
        visited[node]=true;
        while(!queue.isEmpty()){
            for(int i:graph.get(queue.poll())){
                if(visited[i]==false)
                queue.add(i);
                visited[i]=true;
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean visited[]=new boolean[n];
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1&&i!=j)
                    graph.get(i).add(j);
            }
        }
        int counter=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                bfs(visited,i,graph);
                counter++;
            }
        }
        return counter;
    }
}