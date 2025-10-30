class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max=nums[0];
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }
        int left=1;
        int right=max;
        int count=0;
        int ans=max;
        while(left<=right){
            count=0;
            int mid=(left+right)/2;
            for(int i=0;i<n;i++){
                count+=Math.ceil((double)nums[i]/mid);
            }
            if(count>threshold){
                left=mid+1;
            }else{
                ans=mid;
                right=mid-1;
            }
        }
        return ans;
    }
}