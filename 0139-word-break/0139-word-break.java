class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        int  dp[]=new int[n];
        Arrays.fill(dp,-1);

        HashSet<String> set=new HashSet<>(n);
        for(String word:wordDict){
            set.add(word);
        }
        backtracking(s,set,0,n,dp);
        return (dp[0]==1)?true:false;
    }
    public int backtracking(String s,HashSet<String> set,int index,int n,int dp[]){
        if(index==n) return 1;
        if(dp[index]!=-1) return dp[index];
        for(int i=index;i<n;i++){
            if(set.contains(s.substring(index,i+1))){
                if(backtracking(s,set,i+1,n,dp)==1){
                    return dp[index]=1;
                }
            }
        }
        return dp[index]=0;
    }
}