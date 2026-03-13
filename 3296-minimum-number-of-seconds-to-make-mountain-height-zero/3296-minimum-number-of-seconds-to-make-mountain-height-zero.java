class Solution {
    public long minNumberOfSeconds(long mountainHeight, int[] workerTimes) {
        long left=0;
        long right=(long)1e18;
        long ans=right;
       while(left<=right){
          long mid=left+(right-left)/2;
            if(mountainHeight<=helper(mid,workerTimes)){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    
    }
    public long helper(long time ,int arr[]){
        long reduce=0;
        for(int i=0;i<arr.length;i++){
                long x = (2 * time) / arr[i];
                long k = (long)((Math.sqrt(1 + 4.0 * x) - 1) / 2);

            reduce+=k;
        }
        return reduce;
    }
}