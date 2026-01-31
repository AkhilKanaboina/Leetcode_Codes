class Solution {
    public int countElements(int[] nums) {

        int max=nums[0];
        int min=nums[0];

        int n=nums.length;
        if(n==1){
            return 0;
        }
        for(int i=0;i<n;i++){
            if(max<nums[i]){
                max=nums[i];
            }
            if(min>nums[i]){
                min=nums[i];
            }
        }
        int minCount=0;
        int maxCount=0;
        for(int i=0;i<n;i++){
            if(nums[i]==max){
                maxCount++;
            }
            if(nums[i]==min){
                minCount++;
            }
        }
        return n-minCount-maxCount;
    }
}