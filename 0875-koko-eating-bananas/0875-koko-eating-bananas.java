class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int max=piles[0];
        for(int i=0;i<n;i++){
            if(piles[i]>max){
                max=piles[i];
            }
        }
        int left=1;
        int right=max;
        int ans=max;
        int count=0;
        while(left<=right){
            int mid=(left+right)/2;
            count=0;
            for(int i=0;i<n;i++){
                count+=Math.ceil(((double)piles[i]/mid));
            }
          //  if(count>=h){
                
           // }
            if(count>h){
                left=mid+1;
            }else{
                ans=mid;
                right=mid-1;
            }
          
        }
        return ans;
    }
}