class Solution {
    public int maxFrequency(int[] nums, int k) {
        //brute force is to concider a "i" indexed number as max frequcy and checking how may number can reach it after sorting .. better one is using prefix not canculate sum every time using formula num[i]*(r-l+1)-prefix of[l...r]
        int prefix=0;
        Arrays.sort(nums);
        int n=nums.length;
        int left=0;
        int right=0;
        for(right=0;right<n;right++){
            prefix+=nums[right];
            int val=(right-left+1)*nums[right];
            if(val-prefix>k){
                prefix-=nums[left++];
            }
        }
        return n-left;
    }
}