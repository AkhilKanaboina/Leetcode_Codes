class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        List<Integer> minTreeNodes =new ArrayList<>();
        if(n==1){
            minTreeNodes.add[0];
            return minTreeNodes;
        }
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<Integer>());
        }
        int degree[]=new int[n];
        for(int temp[]:edges){
            graph.get(temp[1]).add(temp[0]);
            graph.get(temp[0]).add(temp[1]);
            degree[temp[1]]++;//java dont support like c
            degree[temp[0]]++;
        }
        Queue<Integer> leafNodes=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(degree[i]==1)
            leafNodes.offer(i);
        }
        while(!leafNodes.isEmpty()){
            minTreeNodes.clear();
            int size=leafNodes.size();
            for(int i=0;i<size;i++){
                int leaf=leafNodes.poll();
                minTreeNodes.add(leaf);
                for(int temp:graph.get(leaf)){
                    degree[temp]--;
                    if(degree[temp]==1){
                        leafNodes.offer(temp);
                    }
                }
            }
        }
        return minTreeNodes;
    }
}