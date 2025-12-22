class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double ans=Integer.MIN_VALUE;
        double val=0;
        int n=nums.length;
        int j=0;
        int i=0;
        for(;i<k;i++){
            val+=nums[i];
        }
        if(i==k){
            ans=Math.max(ans,val/k);
        }
        for(i=k;i<n;i++){
            val+=nums[i];
            val-=nums[j++];
            ans=Math.max(ans,val/k);
        }
        return ans;
    }
}