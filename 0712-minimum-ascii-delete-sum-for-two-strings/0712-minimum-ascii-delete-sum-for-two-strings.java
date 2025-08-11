class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int col=s1.length();
        int row=s2.length();
        int dp[][]=new int[row+1][col+1];
        dp[0][0]=0;
        for(int i=1;i<row+1;i++){
            dp[i][0]=dp[i-1][0]+(int)(s2.charAt(i-1));
        }
        for(int i=1;i<col+1;i++){
            dp[0][i]=dp[0][i-1]+(int)(s1.charAt(i-1));
        }
        for(int i=1;i<row+1;i++){
            for(int j=1;j<col+1;j++){
                if(s1.charAt(j-1)==s2.charAt(i-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.min(dp[i-1][j]+s2.charAt(i-1),dp[i][j-1]+s1.charAt(j-1));
                }
            }
        }
        return dp[row][col];
    }
}