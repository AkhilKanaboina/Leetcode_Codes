class Solution {
    public void gameOfLife(int[][] board) {
        int R=board.length;
        int C=board[0].length;
        int temp[][]=new int[R][C];
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                temp[i][j]=board[i][j];
            }
        }
        int dirR[]={-1,-1,-1,0,1,1,1,0};
        int dirC[]={-1,0,1,1,1,0,-1,-1};
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                    int countOnes=0;
                    int countZeros=0;
                for(int d=0;d<8;d++){
                    int newRow=i+dirR[d];
                    int newCol=j+dirC[d];
                    if(newRow>=0 &&newRow<R &&newCol>=0&&newCol<C){
                        if(temp[newRow][newCol]==0){
                            countZeros++;
                        }else{
                            countOnes++;
                        }
                    }
                }
                if(temp[i][j]==1){
                    if(countOnes<2||countOnes>3){
                        board[i][j]=0;
                    }else if(countOnes==2||countOnes==3){
                        board[i][j]=1;
                    }
                }else if(temp[i][j]==0){
                    if(countOnes==3){
                        board[i][j]=1;
                    }
                }
            }
        }
    }
}