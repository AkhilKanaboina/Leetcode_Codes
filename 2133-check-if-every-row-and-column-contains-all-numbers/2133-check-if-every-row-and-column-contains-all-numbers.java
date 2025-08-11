class Solution {
    public boolean checkValid(int[][] matrix) {
        int n=matrix.length;
        boolean row[][]=new boolean[n][n];
        boolean col[][]=new boolean[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int num=matrix[i][j];
                if(num<=0){
                    return false;
                }
                if(row[i][num-1]){
                    return false;
                }
                if(col[num-1][j]){
                    return false;
                }
                row[i][num-1]=true;
                col[num-1][j]=true;
            }
        }
        return true;
    }
}