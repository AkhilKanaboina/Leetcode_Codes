class Solution {
    public long maxArrayValue(int[] nums) {
        int n=nums.length;
        long arr[]=new long[n];
        for(int i=0;i<n;i++){
            arr[i]=nums[i];
        }
        long ans=arr[n-1];
        for(int i=n-1;i>0;i--){
            if(arr[i-1]<=arr[i]){
                arr[i-1]+=arr[i];
            }
            if(arr[i-1]>ans){
                ans=arr[i-1];
            }
        }
        return ans;
    }
}