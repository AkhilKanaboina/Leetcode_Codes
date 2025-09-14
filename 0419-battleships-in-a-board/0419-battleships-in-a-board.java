class Solution {
    int row=0;
    int col=0;
    public void dfs(boolean visited[][],char[][] board,int i,int j){
        int dir[]={0,-1,0,1,0};
        visited[i][j]=true;
        for(int d=0;d<4;d++){
            int r2=i+dir[d];
            int c2=j+dir[d+1];
            if(r2>=0&&c2>=0 && r2<row&&c2<col&&!visited[r2][c2]&&board[r2][c2]=='X'){
                dfs(visited,board,r2,c2);
            }
        }

    }
    public int countBattleships(char[][] board) {
         row=board.length;
         col=board[0].length;
        boolean visited[][]=new boolean[row][col];
        int ans=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(!visited[i][j]&&board[i][j]=='X'){
                    dfs(visited,board,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }
}