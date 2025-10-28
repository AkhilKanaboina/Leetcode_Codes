class Solution {
    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        if(n==0){
            return 0;
        }
        int left=0;
        int right=n-1;
        int index=n;
        if(nums[0]>target){
            return 0;
        }
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                index=mid;
                right=mid-1;
            }else if(nums[mid]<target){
                index=mid;
                left=mid+1;
            }
        }
        return index+1;
    }
}