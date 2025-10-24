class Solution {
     List<Integer> list=new ArrayList<>();
     int row=0;
     int col=0;
    public List<Integer> spiralOrder(int[][] matrix) {
       row=matrix.length;
       col=matrix[0].length;
       dfs(matrix,0,0);
       return list;
    }
    public void dfs(int matrix[][],int i,int j){
        if(!(i>=0&&i<row&&j>=0&&j<col&&matrix[i][j]!=200)){
            return;
        }
        if(matrix[i][j]!=200){
            list.add(matrix[i][j]);
            matrix[i][j]=200;
        }
        dfs(matrix,i,j+1);
        dfs(matrix,i+1,j);
        dfs(matrix,i,j-1);
        dfs(matrix,i-1,j);
    }
}