class Solution {
    public void dfs(Map<String,PriorityQueue<String>> graph,List<String> ans,String key){
        Queue<String> adj=graph.get(key);
        ans.add(key);
        while(adj!=null&&!adj.isEmpty()){
            String temp=adj.poll();
            dfs(graph,ans,temp);
        }
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> ans=new ArrayList<>();
        Map<String,PriorityQueue<String>> graph=new HashMap<>();
        for(List<String> ticket:tickets){
            if(graph.containsKey(ticket.get(0))){
                graph.get(ticket.get(0)).add(ticket.get(1));
            }else{
                PriorityQueue<String> temp=new PriorityQueue<>();
                temp.add(ticket.get(1));
                graph.put(ticket.get(0),temp);
            }
        }
        dfs(graph,ans,"JFK");
        return ans;
    }
}