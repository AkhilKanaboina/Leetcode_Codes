class Solution {
    public int minOperations(int[] nums, int x) {
        //int ans= backTracking(nums,0,n-1,x,0);
        //ans=(ans==Integer.MAX_VALUE)?(-1):ans;
        int n=nums.length;
        int ans=-1;
        long sum=nums[0];
        for(int i=1;i<n;i++){
            sum+=nums[i];
        }
        long target=sum-x;
        long tempSum=0;
        int j=0;
        for(int i=0;i<n;i++){
            tempSum+=nums[i];
            while(tempSum>target && j<=i){
                tempSum-=nums[j];
                j++;
            }
            if(tempSum==target){
                ans=Math.max(ans,i-j+1);
            }
        }
        if(ans==-1){
            return -1;
        }
        return n-ans;
    }
    // public int backTracking(int nums[],int left,int right,int val,int counter){
    //     if(val==0){
    //         return counter;
    //     }
    //     if(val<0){
    //         return Integer.MAX_VALUE;
    //     }
    //     if(left>right){
    //         return Integer.MAX_VALUE;
    //     }
    //     return Math.min(backTracking(nums,left+1,right,val-nums[left],counter+1),backTracking(nums,left,right-1,val-nums[right],counter+1));
    // }
}