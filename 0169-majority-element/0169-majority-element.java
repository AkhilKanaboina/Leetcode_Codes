class Solution {
    public int majorityElement(int[] nums) {
        int ans=0;
        int j=0,n=nums.length,val=nums[0];
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(nums[i]!=nums[j]){
                j=i;
            }
            if((i-j+1)>ans){
                ans=i-j+1;
                val=nums[i];
            }
        }
        return val;
    }
}