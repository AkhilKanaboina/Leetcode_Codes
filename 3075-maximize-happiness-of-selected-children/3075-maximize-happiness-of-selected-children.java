class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long ans=0;
        Arrays.sort(happiness);
        int n=happiness.length;
        int dec=0;
        for(int i=n-1;i>=0 && k>0 ;i--){
            if(happiness[i]>dec)
            ans=ans+(happiness[i]-dec);
            dec++;
            k--;
        }
        return ans;
    }
}