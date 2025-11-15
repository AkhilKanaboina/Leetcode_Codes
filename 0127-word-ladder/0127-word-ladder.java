class Solution {
    Set<String> set=new HashSet<>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       for(String s:wordList){
        set.add(s);
       }
       int ans=bfs(beginWord,endWord);
       return (ans==Integer.MAX_VALUE)?0:ans;
    }
    public int bfs(String beginWord,String endWord){
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(beginWord,1));
        int ans=Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            String temp=queue.peek().first;
            int level=queue.peek().second;
            queue.remove();
            if(temp.equals(endWord)){
                ans=Math.min(ans,level);
            }
            for(int i=0;i<temp.length();i++){
                //char change
                for(char c='a';c<='z';c++){
                    StringBuilder temp2=new StringBuilder(temp);
                    temp2.setCharAt(i,c);
                    if(set.contains(temp2.toString()) && !temp2.equals(temp)){
                        queue.add(new Pair(temp2.toString(),level+1));
                        set.remove(temp2.toString());
                    }
                }
            }
        }
        return ans;
    }
}
class Pair{
    String first;
    int second;
    Pair(String s,int n){
        this.first=s;
        this.second=n;
    }
}