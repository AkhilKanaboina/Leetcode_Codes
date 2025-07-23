class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        boolean b[]=new boolean[(n*n)+1];
        int repeated=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(b[(grid[i][j])]){
                    repeated=grid[i][j];
                }
                b[grid[i][j]]=true;
            }
        }
        int missing=0;
        for(int i=0;i<=(n*n);i++){
            if(!b[i]){
                missing=i;
            }
        }
        return new int[]{repeated,missing};
    }
}