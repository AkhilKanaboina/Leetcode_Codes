class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left=0;
        int n=nums.length;
        int right=n-1;
        while(left<right){
            int mid=(left+right)/2;
            if(mid%2==1){
                if(nums[mid]==nums[mid-1]){
                    left=mid+1;
                }else{
                    right=mid;
                }
            }else{
                if(nums[mid]==nums[mid+1]){
                    left=mid+1;
                }else{
                    right=mid;
                }
            }
        }           
        
        return nums[left];
    }
}