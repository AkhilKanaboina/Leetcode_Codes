class Solution {
    int ans=0;
    public int totalNQueens(int n) {
        boolean col[]=new boolean[n];
        boolean diagonal_up_hash[]=new boolean[2*n-1];
        boolean diagonal_down_hash[]=new boolean[2*n-1];
        backTracking(0,n,col,diagonal_down_hash,diagonal_up_hash);
        return ans;
    }
    public void backTracking(int row,int n,boolean col[],boolean diagonal_down_hash[],boolean diagonal_up_hash[]){
        if(row==n){
            ans++;
            return;
        }
        for(int i=0;i<n;i++){
            if(!col[i] && !diagonal_down_hash[row+i] && !diagonal_up_hash[(n-1)+(row-i)]){
                col[i]=true;
                diagonal_down_hash[row+i]=true;
                diagonal_up_hash[(n-1)+(row-i)]=true;
                backTracking(row+1,n,col,diagonal_down_hash,diagonal_up_hash);
                col[i]=false;
                diagonal_down_hash[row+i]=false;
                diagonal_up_hash[(n-1)+(row-i)]=false;
            }
        }
    }
}