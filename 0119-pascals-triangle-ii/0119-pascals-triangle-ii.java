class Solution {
    public List<Integer> getRow(int n) {
        int dp[][]=new int[n+1][n+1];
        List<Integer> list=new ArrayList<>();
        dp[0][0]=1;
        for(int i=1;i<n+1;i++){
              int prev=0;
              int j=0;
            for(j=0;j<i;j++){
                dp[i][j]=prev+dp[i-1][j];
                prev=dp[i-1][j];
            }
            dp[i][j]=prev;
        }
        for(int i=0;i<n;i++){
            list.add(dp[n][i]);
        }
        list.add(1);
        return list;

    }
}