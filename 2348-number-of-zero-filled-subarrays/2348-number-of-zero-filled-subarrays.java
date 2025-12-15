class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans=0;
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,0);
        int lastUsedNumber=0;
        
        for(int i=0;i<n;i++){
              if(nums[i]==0){
                lastUsedNumber++;
                dp[i]= lastUsedNumber;
              }else{
                lastUsedNumber=0;
              }
            ans=(long)ans+dp[i];
        }
        return ans;
    }
}