class Solution {
    public int fib(int n) {
        // if(n==0){//space consuming
        //     return 0;
        // }else if(n==1){
        //     return 1;
        // }
        // return fib(n-1)+fib(n-2);
        int dp[]=new int[n+1];
        if(n>=0){
            dp[0]=0;
        }
        if(n>=1){
            dp[1]=1;
        }
        for(int i=2;i<n+1;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}