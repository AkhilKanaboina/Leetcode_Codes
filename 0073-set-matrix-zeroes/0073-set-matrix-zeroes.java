class Solution {
    public void setZeroes(int[][] matrix) {
        int R=matrix.length;
        int C=matrix[0].length;
        boolean visited[][]=new boolean[R][C];
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(matrix[i][j]==0){
                    visited[i][j]=true;
                }
            }
        }
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(visited[i][j]){
                    for(int x=0;x<C;x++){
                        matrix[i][x]=0;
                    }
                    for(int x=0;x<R;x++){
                        matrix[x][j]=0;
                    }
                }
            }
        }
    }
}