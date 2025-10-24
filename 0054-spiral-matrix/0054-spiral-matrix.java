class Solution {
     List<Integer> list=new ArrayList<>();
     int row=0;
     int col=0;
    public List<Integer> spiralOrder(int[][] matrix) {
       row=matrix.length;
       col=matrix[0].length;
       dfs_R(matrix,0,0);
       return list;
    }
    // public void dfs(int matrix[][],int i,int j){
    //     if(!(i>=0&&i<row&&j>=0&&j<col&&matrix[i][j]!=200)){
    //         return;
    //     }
    //     if(matrix[i][j]!=200){
    //         list.add(matrix[i][j]);
    //         matrix[i][j]=200;
    //     }
        
    //     dfs(matrix,i-1,j);
    //     dfs(matrix,i,j+1);
    //     dfs(matrix,i+1,j);
    //     dfs(matrix,i,j-1);
       
    // }
     public void dfs_R(int matrix[][],int i,int j){
         if (i < 0 || i >= row || j < 0 || j >= col || matrix[i][j]==200) return;
        for(;i<row&&j<col&& matrix[i][j]!=200;j++){
            list.add(matrix[i][j]);
            matrix[i][j]=200;
        }
        j--;
        dfs_D(matrix,i+1,j);
     }
     public void dfs_D(int matrix[][],int i,int j){
         if (i < 0 || i >= row || j < 0 || j >= col || matrix[i][j]==200) return;
        for(;i<row &&  matrix[i][j]!=200;i++){
            list.add(matrix[i][j]);
            matrix[i][j]=200;
        }
        i--;
        dfs_L(matrix,i,j-1);
     }
     public void dfs_L(int matrix[][],int i,int j){
        if (i < 0 || i >= row || j < 0 || j >= col || matrix[i][j]==200) return;
        for(;j>=0&&  matrix[i][j]!=200;j--){
            list.add(matrix[i][j]);
            matrix[i][j]=200;
        }
        j++;
        dfs_T(matrix,i-1,j);
     }
     public void dfs_T(int matrix[][],int i,int j){
        if (i < 0 || i >= row || j < 0 || j >= col || matrix[i][j]==200) return;
        for(;i>=0&&  matrix[i][j]!=200;i--){
             list.add(matrix[i][j]);
             matrix[i][j]=200;
        }
        i++;
        dfs_R(matrix,i,j+1);
     }
}