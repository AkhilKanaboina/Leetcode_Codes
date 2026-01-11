class Solution {
    public int maxFrequency(int[] nums, int k) {
        //brute force is to concider a "i" indexed number as max frequcy and checking how may number can reach it after sorting .. better one is using prefix not canculate sum every time using formula num[i]*(r-l+1)-prefix of[l...r]
        //long prefix=0;
        int n=nums.length;
        Arrays.sort(nums);
        long prefix[]=new long[n+1];
        prefix[0]=0;
        for(int i=1;i<=n;i++){
            prefix[i]=prefix[i-1]+nums[i-1];
        }
        int left=0;
        int ans=1;
        for(int right=0;right<n;right++){
            long val=(long)nums[right]*(right-left+1);
            while(left<right && val-(prefix[right+1]-prefix[left])>k){
                left++;
                val=(long)(long)nums[right]*(right-left+1);
            }
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}