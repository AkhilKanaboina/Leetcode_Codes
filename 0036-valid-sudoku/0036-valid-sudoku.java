class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean row[][]=new boolean[9][9];
        boolean col[][]=new boolean[9][9];
        boolean box[][]=new boolean[9][9];

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                int num=board[i][j]-'0';
                if(row[i][num-1]){
                    return false;
                }
                if(col[num-1][j]){
                    return false;
                }
                row[i][num-1]=true;
                col[num-1][j]=true;

                int boxIndex = (i / 3) * 3 + (j / 3);
                if(box[boxIndex][num-1])
                    return false;
                box[boxIndex][num-1]=true;
            } 
        }
        return true;
    }
}