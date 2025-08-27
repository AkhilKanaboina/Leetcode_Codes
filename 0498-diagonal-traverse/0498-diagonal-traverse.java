class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int row=mat.length;
        int col=mat[0].length;
        int answer[]=new int[row*col];
        int key=0;
        int n=row+col;
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        int index=0;
        for(int k=0;k<n;k+=1){
           ArrayList<Integer> list=new ArrayList<>();
             if(k<col){
                index=k;
                for(int i=0,j=index;j>=0;j--,i++){
                     if(i>=0&&j>=0&&i<row&&j<col){
                        list.add(mat[i][j]);
                     }
                }
                
             }else{
                index=k-col+1;
                for(int i=index,j=col-1;i<row;i++,j--){
                    if(i>=0&&j>=0&&i<row&&j<col){
                        list.add(mat[i][j]);
                    }
                }
             }
             if(k%2==0){
                   Collections.reverse(list);
             }
             ans.add(list);
        }
        for(ArrayList<Integer> temp:ans){
            for(Integer a:temp){
                answer[key++]=a;
            }
        }
        return answer;
    }
}