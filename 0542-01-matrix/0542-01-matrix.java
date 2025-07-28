class Solution {
    int dir[]={-1,0,1,0,-1};
    int R=0,C=0;
    public int bfs(int i,int j,int mat[][],boolean visited[][]){
        visited[i][j]=true;
        if(mat[i][j]==0){
            return 1;
        }
        Queue<int []> queue=new ArrayList<>();
        queue.add(new int[]{i,j});
        while(!queue.isEmpty()){
            int temp[]=queue.poll();
            int r=temp[0];
            int c=temp[1];
            int min=Integer.MAX_VALUE;
            for(int d=0;d<4;d++){
                int newRow=r+dir[d];
                int newCol=c+dir[d+1];
                if(visited[newRow][newCol]){
                    return mat[newRow][newCol]+1;
                }
                if(newRow>=0&&newRow<R&&newCol>=0&&newCol<C&&!visited[newRow][newCol]&&mat[newRow][newCol]==1){
                    min=Math.min(min,bfs(newRow,newCol,mat,visited));  
                }
            }
            math[r][c]=min;
        }
       
    }
    public int[][] updateMatrix(int[][] mat) {
        R=mat.length;
        C=mat[0].length;
        boolean visited[][]=new boolean[R][C];

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(mat[i][j]!=0&&!visited[i][j]){
                    bfs(i,j,mat,visited);
                }
            }
        }
    }
}