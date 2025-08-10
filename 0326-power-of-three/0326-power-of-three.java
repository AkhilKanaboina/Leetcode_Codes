class Solution {
    public boolean isPowerOfThree(int n) {
        int low=0,high=15;
        while(Math.pow(3,high)<n){
            low=high;
            high+=15;
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(Math.pow(3,mid)==n){
                return true;
            }else if(Math.pow(3,mid)>n){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return false;
    }
}