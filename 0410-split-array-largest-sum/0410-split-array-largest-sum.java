class Solution {
    public int splitArray(int[] nums, int k) {
        int sum=nums[0];
        int max=nums[0];
        int n=nums.length;
        for(int i=1;i<n;i++){
            sum+=nums[i];
            if(nums[i]>max){
                max=nums[i];
            }
        }
        int low=max;
        int high=sum;
        int ans=sum;
        while(low<=high){
            int mid=(low+high)/2;
            int subarrays=calculateMaxSubArrays(nums,mid,n);
            if(subarrays<=k){
                ans=Math.min(ans,mid);
                high=mid-1;
            }else if(subarrays>k){
                low=mid+1;
            }
        }
        return ans;

    }
    private int calculateMaxSubArrays(int arr[],int max,int n){
        int subarrays=1;
        int currentValue=arr[0];
        for(int i=1;i<n;i++){
            if(currentValue+arr[i]<=max){
                currentValue+=arr[i];
            }else{
                currentValue=arr[i];
                subarrays++;
            }
        }
        return subarrays;
    }
}