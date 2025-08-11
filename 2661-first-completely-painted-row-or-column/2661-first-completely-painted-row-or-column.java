class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int row[]=new int[m];
        int col[]=new int[n];
        Arrays.fill(row,0);
        Arrays.fill(col,0);

        HashMap<Integer,int[]> map=new HashMap<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                map.put(mat[i][j],new int[]{i,j});
            }
        }
        for(int index=0;index<arr.length;index++){
            int temp[]=map.get(arr[index]);
            row[temp[0]]++;
            col[temp[1]]++;
            if(row[temp[0]]==n||col[temp[1]]==m){
                return index;
            }
        }
       return 0;
    }
}