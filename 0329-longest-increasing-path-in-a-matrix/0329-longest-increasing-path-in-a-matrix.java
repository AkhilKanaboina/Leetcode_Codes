class Solution {
    int temp[][];
    int ans[][];
    int row,col;
    int dir[]={0,-1,0,1,0};
    public int dfs(int i,int j){
        if(ans[i][j]!=0){
            return ans[i][j];
        }
        int max=1;
        for(int d=0;d<4;d++){
            int newRow=i+dir[d];
            int newCol=j+dir[d+1];
            if(newRow>=0&&newRow<row &&newCol>=0&&newCol<col&&temp[newRow][newCol]>temp[i][j]){
                max=Math.max(max,1+dfs(newRow,newCol));
            }
        }
        return max;

    }
    public int longestIncreasingPath(int[][] matrix) {
         row=matrix.length;
         col=matrix[0].length;
        ans=new int[row][col];
        temp=matrix;
        int max=1;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                max=Math.max(dfs(i,j),max);
            }
        }
        return max;
    }
}