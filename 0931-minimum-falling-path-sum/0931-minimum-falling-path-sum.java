class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        //dp
        for(int i=1;i<row;i++){
            for(int j=0;j<col;j++){
                int val=matrix[i][j];
                for(int a=-1;a<=1;a++){
                    matrix[i][j]=matrix[i-1][j];
                    if((a+j)>=0 && (a+j)<col){
                        matrix[i][j]=Math.min(matrix[i][j],matrix[i-1][a+j]);
                    }
                }
                matrix[i][j]+=val;
            }
        }
        
        //min ans
        int ans=matrix[row-1][0];
        for(int i=0;i<col;i++){
            ans=Math.min(matrix[row-1][i],ans);
        }
        return ans;
    }
}