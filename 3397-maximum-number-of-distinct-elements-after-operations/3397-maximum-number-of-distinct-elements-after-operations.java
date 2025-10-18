class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int nextVal=Integer.MIN_VALUE;
        int ans=0;
        for(int i=0;i<n;i++){
           int temp=Math.max(nextVal,nums[i]+(-k));
           if(temp<=(nums[n-1]+k)){
            ans++;
           }
           nextVal=temp+1;
        }
        return ans;
    }
}