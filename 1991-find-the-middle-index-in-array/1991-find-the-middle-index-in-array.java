class Solution {
    public int findMiddleIndex(int[] arr) {
        int n=arr.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        if(sum-arr[0]==0){
            return 0;
        }
        
        int temp=arr[0];
        for(int i=1;i<n;i++){
            if(temp==(sum-temp-arr[i])){
                return i;
            }
            temp+=arr[i];
        }
        if(sum-arr[n-1]==0){
            return n-1;
        }
        return -1;
    }
}