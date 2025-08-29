class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int row=mat.length;
        int col=mat[0].length;

        for(int i=0;i<row;i++){
            ArrayList<Integer> list=new ArrayList<>();
            for(int j=0;j<col&&i<row &&(i+j)<(row);j++){
               list.add(mat[j+i][j]);
            }
            Collections.sort(list);
            for(int j=0;j<col&&i<row &&(i+j)<(row);j++){
               mat[i+j][j]=list.get(j);
            }
        }
        for(int i=1;i<col;i++){
            ArrayList<Integer> list=new ArrayList<>();
            for(int j=0;j<row&&(i+j)<col;j++){
                list.add(mat[j][j+i]);
            }
            Collections.sort(list);
            for(int j=0;j<row&&(i+j)<col;j++){
                mat[j][j+i]=list.get(j);
            }
        }
        return mat;
    }
}