class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1,right=0;
        for(int i:piles){
            right=Math.max(right,i);
        }
        int ans=right;
        while(left<=right){
            int mid=left+(right-left)/2;
            long temp=0;
            for(int i:piles){
                temp+=(i/mid);
                if(0<(i%mid)){
                    temp++;
                }
            }
            if(temp<=h){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
}