class Solution {
    public int numSquares(int n) {
    
        int dp[]=new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            int localAnswer=Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                localAnswer=Math.min(localAnswer,dp[i-j*j]+1);
            }
            dp[i]=localAnswer;
        }
        return dp[n];
    }
}