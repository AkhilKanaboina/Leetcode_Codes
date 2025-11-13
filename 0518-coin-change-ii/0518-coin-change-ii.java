class Solution {
    int n;
    int amount;
  //  Map<String,Integer> map=new HashMap<>();
    int dp[][];
    public int change(int amount, int[] coins) {
        this.amount=amount;
        n=coins.length;
        dp=new int[n][amount+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dp_backTracking(0,coins,0);
    }
    public int dp_backTracking(int val,int coins[],int index){
        if(val==amount){
            return 1;
        }
        if(val>amount){
            return 0;
        }
        // String str=val+","+index;
        // if(map.containsKey(str)){
        //     return map.get(str);
        // }
        if(dp[index][val]!=-1){
            return dp[index][val];
        }
        int ans=0;
        for(int i=index;i<n;i++){
            ans+=dp_backTracking(val+coins[i],coins,i);
        }
       // map.put(str,ans);
        dp[index][val]=ans;
        return ans;
    }
}