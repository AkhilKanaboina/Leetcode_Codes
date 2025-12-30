class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n=position.length;
        int low=1;
        int high=position[n-1]-position[0];
        int ans=-1;

        while(low<=high){
            int mid=(low+high)/2;
            if(isPossible(position,mid,m,n)){
                ans=Math.max(ans,mid);
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
    public boolean isPossible(int position[],int force,int m,int n){
        int magnetCount=1;
        int pos=position[0];
        for(int i=1;i<n;i++){
            if(position[i]-pos>=force){
                magnetCount++;
                pos=position[i];
            }
        }
        if(magnetCount>=m) return true;
        return false;
    }
}