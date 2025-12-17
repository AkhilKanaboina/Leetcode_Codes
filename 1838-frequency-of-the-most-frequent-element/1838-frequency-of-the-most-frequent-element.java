class Solution {
    public int maxFrequency(int[] nums, int k) {
        //brute force is to concider a "i" indexed number as max frequcy and checking how may number can reach it after sorting .. better one is using prefix not canculate sum every time using formula num[i]*(r-l+1)-prefix of[l...r]
        Arrays.sort(nums);
        int n=nums.length;
        int ans=0;
        long slideSum=0;
        int cost=0;
        int left=0;
        int right=0;
         for(right=0;right<n;right++){
           slideSum+=nums[right];
            while((long)(right-left+1)*nums[right]-slideSum>k && left<=right){
                slideSum-=nums[left];
                left++;
            }
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}