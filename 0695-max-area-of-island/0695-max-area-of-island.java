class Solution {
    int row=0;
    int col=0;
    public int dfs(boolean visited[][],int grid[][],int i,int j){
        int count=1;
        visited[i][j]=true;
        int dir[]={0,-1,0,1,0};

        for(int d=0;d<4;d++){
            int newRow=i+dir[d];
            int newCol=j+dir[d+1];
            if(newRow>=0&&newRow<row &&newCol>=0 && newCol<col && !visited[newRow][newCol] && grid[newRow][newCol]==1){
                count=count+(dfs(visited,grid,newRow,newCol));
            }
        }
        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        row=grid.length;
        col=grid[0].length;
        boolean visited[][]=new boolean[row][col];
        int max=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    max=Math.max(max,dfs(visited,grid,i,j));
                }
            }
        }
        return max;
    }
}