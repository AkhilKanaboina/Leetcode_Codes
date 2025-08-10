class Solution {
    public boolean isPowerOfTwo(int n) {
        int low=0,high=10;
        while(Math.pow(2,high)<n){
            low=high;
            high+=10;
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(Math.pow(2,mid)==n){
                return true;
            }else if(Math.pow(2,mid)>n){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return false;
    }
}