class Solution {
    
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int n=coins.length;
        int[][] memo = new int[n][amount + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        int ans = dp(coins, n - 1, amount,memo); 
         return (ans >= Integer.MAX_VALUE / 10) ? -1 : ans;
    }
    public int dp(int coins[],int n,int target,int memo[][]){
        if(target==0){
            return 0;
        }else if(target<0 ||n<0){
            return Integer.MAX_VALUE/10;
        }
        if(memo[n][target]!=-1){
            return memo[n][target];
        }
        int notTake=dp(coins,n-1,target,memo);
        int take=1+dp(coins,n,target-coins[n],memo);
        memo[n][target]=Math.min(notTake,take);
        return memo[n][target];
    }
}