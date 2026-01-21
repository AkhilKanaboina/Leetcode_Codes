class Solution {
    public int longestSubarray(int[] nums) {
        int ans=0;
        int left=0;
        int n=nums.length;
        int counter=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                counter++;
            }
            while(counter>1 && left<n){
                if(nums[left]==0){
                    counter--;
                }
                left++;
            }
            ans=Math.max(ans,i-left+1);
        }
        return ans-1;
    }
}