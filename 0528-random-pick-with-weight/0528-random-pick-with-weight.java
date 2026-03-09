class Solution {
    int n;
    int prefix[];
    int totalWeight=0;
    int w[];
    public Solution(int[] w) {
        n=w.length;
        this.w=w;
        prefix=new int[n];
        if(n==0){
            return;
        }
        prefix[0]=w[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+w[i];
        }
        totalWeight=prefix[n-1];
    }
    
    public int pickIndex() {
        int val=(int)(Math.random()*totalWeight)+1;
        int index=BinarySearch(val);
        return index;
    }
    public int BinarySearch(int val){
        int low=0;//left
        int high=prefix.length-1;//right
        int index=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(prefix[mid]>=val){
                index=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return index;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */