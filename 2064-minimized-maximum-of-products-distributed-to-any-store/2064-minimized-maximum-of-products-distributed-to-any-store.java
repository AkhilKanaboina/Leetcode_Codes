class Solution {
    public int minimizedMaximum(int n, int[] q) {
        int max=q[0];
        int size=q.length;
        for(int i=0;i<size;i++){
            if(q[i]>max){
                max=q[i];
            }
        }
        int left=1;
        int right=max;
        int count=0;
        int ans=max;
        while(left<=right){
            int mid=(left+right)/2;
            count=0;
            for(int i=0;i<size;i++){
                count+=(Math.ceil((double)q[i]/mid));
            }
            // if(count==n){
            //     return mid;
            // }
            if(count>n){
                left=mid+1;
            }else{
                ans=mid;
                right=mid-1;
            }
        }
        return ans;
    }
}