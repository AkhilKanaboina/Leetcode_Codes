class Solution {
    int grid[][];
    
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        grid=new int[m][n];
        //gard=2
        for(int temp[]:guards){
            grid[temp[0]][temp[1]]=2;
        }
        //wall=3
        for(int temp[]:walls){
            grid[temp[0]][temp[1]]=3;
        }
        for(int temp[]:guards){
            dfs(temp[0],temp[1],m,n);
        }
       int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) count++;
            }
        }
        return count;
    }
    public void dfs(int i,int j,int m,int n){
        grid[i][j]=2;
        //dfs(i-1,j);
        int iTemp=i,jTemp=j;
        while(iTemp-->0){
            if(grid[iTemp][jTemp]<2){
                grid[iTemp][jTemp]=1;
            }else{
                break;
            }
        }
      //  dfs(i+1,j);
        iTemp=i;jTemp=j;
        while(jTemp++<n-1){
            if(grid[iTemp][jTemp]<2){
                grid[iTemp][jTemp]=1;
            }else{
                break;
            }
        }
       // dfs(i,j-1);
        iTemp=i;jTemp=j;
        while(jTemp-->0){
            if(grid[iTemp][jTemp]<2){
                grid[iTemp][jTemp]=1;
            }else{
                break;
            }
        }
       // dfs(i,j+1);
        iTemp=i;jTemp=j;
        while(iTemp++<m-1){
             if(grid[iTemp][jTemp]<2){
                grid[iTemp][jTemp]=1;
            }else{
                break;
            }
        }
    }
}