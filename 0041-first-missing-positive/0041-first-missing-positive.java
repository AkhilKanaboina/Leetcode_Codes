class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        // can use Hashing or Sort
        Arrays.sort(nums);
        int missing=1;
        int i=0;
        while(i<n && nums[i]<=0 ){
            i++;
        }
        for(;i<n;i++){
            if(nums[i]==missing){
                missing++;
            }
        }
        return missing;
    }
}