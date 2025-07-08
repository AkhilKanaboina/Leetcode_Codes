class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
       int m=obstacleGrid.length;
       int n=obstacleGrid[0].length;
       boolean b=true;
       if(obstacleGrid[0][0]==1){
        return 0;
       }
       for(int i=0;i<m;i++){
        if(obstacleGrid[i][0]!=1&&b){
            obstacleGrid[i][0]=1;
        }else{
            obstacleGrid[i][0]=0;
            b=false;
        }
       }
       b=true;
       for(int j=1;j<n;j++){
        if(obstacleGrid[0][j]!=1&&b){
            obstacleGrid[0][j]=1;
        }else{
            obstacleGrid[0][j]=0;
            b=false;
        }
        
       }
       
       for(int i=1;i<m;i++){
        for(int j=1;j<n;j++){
            if(obstacleGrid[i][j]==1){
                obstacleGrid[i][j]=0;
            }else{
                obstacleGrid[i][j]=obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
            }
        }
       }
       return obstacleGrid[m-1][n-1];
   
    }
}