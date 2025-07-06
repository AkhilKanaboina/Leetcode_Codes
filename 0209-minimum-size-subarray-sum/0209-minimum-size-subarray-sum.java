class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0, n = nums.length;
        int sum = nums[j];
        int res, ans = Integer.MAX_VALUE;
        while(j<n&&i<=j){
            if(sum>=target){
                ans=Math.min(ans,(j-i+1));
            }
            
            if(sum<target&& j<n-1){
                j++;
                sum+=nums[j];

            }else{
                sum-=nums[i];
                i++;
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
