class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n-1;){
            if(nums[i]==nums[i+1]){
                i+=2;
            }else{
                return nums[i];
            }
        }
        return nums[n-1];
    }
}