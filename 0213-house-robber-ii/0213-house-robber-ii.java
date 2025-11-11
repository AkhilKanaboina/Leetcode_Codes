class Solution {
    int n;
    public int rob(int[] nums) {
        n=nums.length;
        return Math.max(dp(nums,0,n-2),dp(nums,1,n-1));
    }
    public int dp(int nums[],int start,int end){
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0],nums[1]);
        }
        int dpVal[]=new int[n];
        dpVal[start]=nums[start];
        if(start<=end)
        dpVal[start+1]=Math.max(nums[start+1],dpVal[start]);
        for(int i=start+2;i<=end;i++){
            dpVal[i]=Math.max(dpVal[i-1],dpVal[i-2]+nums[i]);
        }
        return dpVal[end];
    }
}