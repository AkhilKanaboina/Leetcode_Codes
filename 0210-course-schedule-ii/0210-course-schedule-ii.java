class Solution {
     Stack<Integer> ans=new Stack<>();
     boolean Cycle_detected=false;
    public void dfs(int i,boolean visited[],boolean recStack[],ArrayList<ArrayList<Integer>> graph){
        visited[i]=true;
        recStack[i]=true;
        for(int temp:graph.get(i)){
             if(!visited[temp]){
                dfs(temp,visited,recStack,graph);
             }
             if(recStack[temp]){
                Cycle_detected=true;
                return;
             }
        }
        ans.push(i);
        recStack[i]=false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int temp[]:prerequisites){
            graph.get(temp[1]).add(temp[0]);
        }
        boolean recStack[]=new boolean[numCourses];
        boolean visited[]=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!visited[i])
            dfs(i,visited,recStack,graph);
            if(Cycle_detected){
                return new int[0];
            }
        }
        int arr[]=new int[numCourses];
        int i=0;
       while(!ans.isEmpty()){
            arr[i]=ans.pop();
            i++;
        }
        return arr;
    }
}