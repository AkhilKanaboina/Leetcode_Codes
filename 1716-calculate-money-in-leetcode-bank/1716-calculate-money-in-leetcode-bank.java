class Solution {
    public int totalMoney(int n) {
        int dp[]=new int[7];
        for(int i=0;i<7;i++){
            dp[i]=i+1;
        }
        int i=0;
        int ans=0;
        for(int j=0;j<n;j++){
            if(i==7){
                i=0;
            }
            ans+=dp[i];
            dp[i]+=1;
            i++;
        }
        return ans;
    }
}