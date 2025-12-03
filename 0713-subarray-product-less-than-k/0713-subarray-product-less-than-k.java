class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int mul=1;
        int left=0;
        int ans=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            mul*=nums[i];
            while(left<=i && mul>=k){
                mul/=nums[left];
                left++;
            }
            ans+=(i-left+1);
        }
        return ans;
    }
}