class Solution {
    boolean visited[][];
    int row;
    int col;
    public void solve(char[][] board) {
         row=board.length;
         col=board[0].length;
        visited=new boolean[row][col];
        for(int i=0;i<row;i++){
            if(board[i][0]=='O' && !visited[i][0]){
                bfs(i,0,board);
            }
            if(board[i][col-1]=='O' && !visited[i][col-1]){
                bfs(i,col-1,board);
            }
        }
        for(int i=0;i<col;i++){
            if(board[0][i]=='O' && !visited[0][i]){
                bfs(0,i,board);
            }
            if(board[row-1][i]=='O' && !visited[row-1][i]){
                bfs(row-1,i,board);
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='O' && !visited[i][j]){
                    board[i][j]='X';
                }
            }
        }
    }
    int dir[]={-1,0,1,0,-1};

    public void bfs(int i,int j,char board[][]){
        Queue<int []> queue=new LinkedList<>();
        queue.add(new int[]{i,j});
        //visited[i][j]=true;
        while(!queue.isEmpty()){
            int temp[]=queue.poll();
            visited[temp[0]][temp[1]]=true;
            for(int d=0;d<4;d++){
                int newRow=dir[d]+temp[0];
                int newCol=dir[d+1]+temp[1];
                if(newRow>=0 && newRow<row &&newCol>=0 && newCol<col && board[newRow][newCol]=='O'&& !visited[newRow][newCol]){
                    visited[newRow][newCol]=true;
                    queue.add(new int[]{newRow,newCol});
                }
            }
        }
    }
}