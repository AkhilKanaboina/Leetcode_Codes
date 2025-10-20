class Solution {
    public char[][] board;
    boolean found=false;
    public List<Integer> indexs=new ArrayList<>();
    public boolean row[][]=new boolean[9][9];
    public boolean col[][]=new boolean[9][9];
    public boolean block[][]=new boolean[9][9];

    public void solveSudoku(char[][] board) {
        this.board=board;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    indexs.add(((i*9)+j));
                }else{
                    int digit=board[i][j]-'1';
                    row[i][digit]=true;
                    col[j][digit]=true;
                    block[(i / 3) * 3 + (j / 3)][digit]=true;
                }
            }
        }
        SudokuSolver_BackTrack(0);
    }
    public void SudokuSolver_BackTrack(int index){
        if(index==indexs.size()){
            found=true;
            return;
        }
        int i=indexs.get(index)/9;
        int j=indexs.get(index)%9;
        for(int n=0;n<9;n++){
            if(!row[i][n]&&!col[j][n]&&!block[(i / 3) * 3 + (j / 3)][n]){
                row[i][n]=true;
                col[j][n]=true;
                block[(i / 3) * 3 + (j / 3)][n]=true;
                board[i][j]=(char)(n+'1');
                SudokuSolver_BackTrack(index+1);
                if(found){
                    return;
                }
                row[i][n]=false;
                col[j][n]=false;
                block[(i / 3) * 3 + (j / 3)][n]=false;

            }

        }
    }
}