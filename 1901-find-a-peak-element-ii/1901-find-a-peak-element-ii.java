class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int row=mat.length;
        int col=mat[0].length;

        int low=0;
        int high=row-1;

        while(low<=high){
            int mid=(low+high)/2;
            int column=maxColumnElement(mat[mid],col);
            int top=(mid-1>=0)?mat[mid-1][column]:-1;
            int down=(mid+1<row)?mat[mid+1][column]:-1;
            int val=mat[mid][column];
            if(top< val && val>down){
                return new int[]{mid,column};
            }else if(top < val){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return new int[]{-1,-1};
    }
    private int maxColumnElement(int mat[],int n){
        int index=0;
        int val=mat[0];
        for(int i=0;i<n;i++){
            if(mat[i]>val){
                val=mat[i];
                index=i;
            }
        }
        return index;
    }

}