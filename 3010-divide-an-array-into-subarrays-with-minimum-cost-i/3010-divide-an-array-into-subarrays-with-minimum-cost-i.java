class Solution {
    public int minimumCost(int[] nums) {
        int a=nums[0];
        int max1=100;
        int max2=100;
        int n=nums.length;
        for(int i=1;i<n;i++){
            if(max1>nums[i]){
                if(max2>max1){
                    max2=max1;
                }
                max1=nums[i];
            }else if(max2>nums[i]){
                max2=nums[i];
            }
        }
        return a+max1+max2;
    }
}