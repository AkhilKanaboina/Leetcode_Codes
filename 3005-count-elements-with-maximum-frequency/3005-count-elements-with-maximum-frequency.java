class Solution {
    public int maxFrequencyElements(int[] nums) {
        int fre[]=new int[101];
        int max=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            fre[nums[i]]++;
            max=Math.max(fre[i],max);
        }
        int ans=0;
        for(int i=0;i<101;i++){
            if(fre[i]==max){
                ans+=max;
            }
        }
        return ans;
    }
}