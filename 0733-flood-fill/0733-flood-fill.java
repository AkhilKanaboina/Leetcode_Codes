class Solution {
    int dir[]={-1,0,1,0,-1};
    int c=0,r=0;
    public void dfs(int i,int j,int[][] image,int val,boolean visited[][]){
        visited[i][j]=true;
        for(int d=0;d<4;d++){
            int newRow=i+dir[d];
            int newCol=j+dir[d+1];
            if(newRow>=0&&newRow<r&&newCol>=0&&newCol<c&& image[i][j]==image[newRow][newCol]&&!visited[newRow][newCol]){
                dfs(newRow,newCol,image,val,visited);
            }
        }
        image[i][j]=val;
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
         r=image.length;
         c=image[0].length;
        boolean visited[][]=new boolean[r][c];
        int val=color;
        dfs(sr,sc,image,val,visited);
        return image;
    }
}