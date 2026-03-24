class Solution {
    public long minimumRemoval(int[] beans) {
        int n=beans.length;
        long prefix[]=new long[n+1];
        Arrays.sort(beans);
        prefix[0]=0;
        for(int i=0;i<n;i++){
            prefix[i+1]=prefix[i]+beans[i];
        }
        long min=sum(beans);
        for(int i=0;i<n;i++){
            long remove_from_greater_elements=(long)prefix[n]-prefix[i]-(long)(n-i)*beans[i];
            long remove_from_minimum_elements=prefix[i];
            min=Math.min(min,remove_from_greater_elements+remove_from_minimum_elements);
        }
        return min;
    }
    public long sum(int beans[]){
        long sum=0;
        for(int val:beans){
            sum+=val;
        }
        return sum;
    }
}