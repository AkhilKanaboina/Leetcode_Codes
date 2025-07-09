class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int r=dungeon.length;
        int c=dungeon[0].length;
        int dp[][]=new int[r+1][c+1];
        for(int i=0;i<r+1;i++){
            dp[i][c]=Integer.MAX_VALUE;
        }
        for(int j=0;j<c+1;j++){
            dp[r][j]=Integer.MAX_VALUE;
        }
        dp[r][c-1]=dp[r-1][c]=1;
        for(int i=r-1;i>=0;i--){
            for(int j=c-1;j>=0;j--){
                int local=(Math.min(dp[i+1][j],dp[i][j+1]))-dungeon[i][j];
                dp[i][j]=(Math.max(1,local));
            }
        }
        return dp[0][0];


    }
}