class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            max=Math.max(max,num);
        }

        int sumTable[]=new int[max+1];
        Arrays.fill(sumTable,0);
        for(int num:nums){
            sumTable[num]+=num;
        }
        int dp[]=new int[max+1];
        dp[0]=sumTable[0];
        dp[1]=sumTable[1];
        int ans=dp[1];
        for(int i=2;i<=max;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+sumTable[i]);
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}