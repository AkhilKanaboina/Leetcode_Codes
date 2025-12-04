class Solution {
    List<List<String>> ans=new ArrayList<>();
    List<String> list=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
       // boolean rowHash[]=new boolean[n];
        boolean colHash[]=new boolean[n];
        boolean diagonal_down_Hash[]=new boolean[2*n-1];
        boolean diagonal_up_Hash[]=new boolean[2*n-1];
        backTracking(0,n,colHash,diagonal_down_Hash,diagonal_up_Hash);
        return ans;
    }
    public void backTracking(int j,int n,boolean colHash[],boolean diagonal_down_Hash[],boolean diagonal_up_Hash[]){
        if(j==n){
            ans.add(new ArrayList<>(list));
            return;
        }
        char c[]=new char[n];
        Arrays.fill(c,'.');
        for(int i=0;i<n;i++){
            if( !colHash[i] && !diagonal_down_Hash[j+i] && !diagonal_up_Hash[(n-1)+(j-i)]){
                c[i]='Q';
                list.add(new String(c));
                //rowHash[i]=true;
                colHash[i]=true;
                diagonal_down_Hash[j+i]=true;
                diagonal_up_Hash[(n-1)+(j-i)]=true;
                backTracking(j+1,n,colHash,diagonal_down_Hash,diagonal_up_Hash);
               // rowHash[i]=false;
                colHash[i]=false;
                diagonal_down_Hash[i+j]=false;
                diagonal_up_Hash[(n-1)+(j-i)]=false;
                list.remove(list.size()-1);
                c[i]='.';
            }
        }
    }
}