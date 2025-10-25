class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int ans=nums[0];
        int val=nums[0];
        for(int i=1;i<n;i++){
            val=Math.max(nums[i],val*nums[i]);
            ans=Math.max(ans,val);
        }
        return ans;
    }
}