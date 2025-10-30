class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int sum=weights[0];
        int max=weights[0];
        for(int i=1;i<n;i++){
            if(max<weights[i]){
                max=weights[i];
            }
            sum+=weights[i];
        }
        int left=max;
        int right=sum;
        int ans=sum;
        while(left<=right){
            int mid=(left+right)/2;
            int load=0;
            int localAns=1;
            for(int i=0;i<n;i++){
                if(mid<weights[i]+load){
                    localAns++;
                    load=weights[i];
                }else{
                    load+=weights[i];
                }
            }
            if(localAns<=days){
                right=mid-1;
                ans=mid;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
}