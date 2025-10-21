class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        int ans=0;
        if(nums[0]==1){
            dp[0]=1;
            ans=Math.max(ans,dp[0]);
        }else{
            dp[0]=0;
        }
        
        for(int i=1;i<n;i++){
            if(nums[i]==1){
                dp[i]+=(dp[i-1]+1);
                 ans=Math.max(ans,dp[i]);
            }else{
                dp[i]=0;
            }
        }
        return ans;
    }
}