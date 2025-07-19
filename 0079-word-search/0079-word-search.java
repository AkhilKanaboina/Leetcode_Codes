class Solution {
    int row;
    int column;
    private String pattern;
    char temp[][];

    public boolean dfs(int i,int j,int key){
       if (key == pattern.length() - 1) {
              return (pattern.charAt(key) == temp[i][j]);
          }
        if(pattern.charAt(key)!=temp[i][j]){
            return false;
        }
        char c=temp[i][j];
        temp[i][j]='0';
        int directions[]={0,-1,0,1,0};
        for(int d=0;d<4;d++){
            int newRow=i+directions[d];
            int newCol=j+directions[d+1];
            if(newRow>=0&&newRow<row&&newCol>=0&&newCol<column&&temp[newRow][newCol]!='0') 
            { if(dfs(newRow,newCol,key+1)){
                return true;
            }
            }

        }
        temp[i][j]=c;
        return false;
    }
    public boolean exist(char[][] board, String word) {
         this.row=board.length;
         this.column=board[0].length;
         this.temp=board;
         this.pattern=word;
        int k=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(board[i][j]==(word.charAt(0))){
                    if(dfs(i,j,0))
                    return true;
                }
            }
        }
        return false;
    }
}